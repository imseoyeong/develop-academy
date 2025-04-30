-- 1) madang.orders에 구매한 서적의 개수를 입력할 필드를 추가한다.(기본 값 1):필드이름 자유
alter table madang.orders add bookcount int default 1;

-- 2) madang.book에 각 서적에 대해 입고된 서적의 개수가 들어 갈 필드를 추가한다.(기본 값 100)필드이름 자유
alter table madang.book add stock int default 100;

-- 3) madang.customer에 고객등급을 입력할 필드를 추가한다.(기본값: bronze) 필드이름 자유
alter table madang.customer add grade varchar(10) default 'bronze';

-- 4) 고객등급변경내역 테이블을 생성한다.(일련번호,고객아이디, 변경날짜, 이전등급, 변경등급)
use madang;
drop table if exists grade_history;
create table grade_history(
	historyid int auto_increment primary key,
    custid int not null,
    changedate date,
    before_grade varchar(10) not null,
    after_grade varchar(10),
    foreign key (custid) references customer (custid)
);

-- 5) 총 구입액을 기준(기준액 자유)으로 고객등급을 일괄처리하는 프로시저를 생성한다
use madang;
drop procedure if exists gradeProc;
delimiter //
create procedure gradeProc()
begin
	declare cust_id int;
    declare totalprice double;
    declare endOfRow boolean default false;
    
	declare grade_cursor cursor for
    select custid, sum(saleprice * bookcount) as total_price
    from orders
    group by custid;
    
    declare continue handler for not found
		set endOfRow = true;
    
	open grade_cursor;
    
	cursor_loop: loop
		fetch grade_cursor into cust_id, totalprice;
        if endOfRow then
			leave cursor_loop;
		end if;
    
		case
			when totalprice >= 35000 then
				update customer set grade = 'gold' where custid = cust_id;
			when totalprice >= 20000 then
				update customer set grade = 'silver' where custid = cust_id;
			else
				update customer set grade = 'bronze' where custid = cust_id;           
		end case;
	end loop;
    
    close grade_cursor;
end //
delimiter ;

call gradeProc();

-- 6) 고객등급이 변경되면 변경정보를 고객등급변경내역 테이블에 추가하는 트리거를 생성한다.
drop trigger if exists gradeTrg;
delimiter //
create trigger gradeTrg
	after update
    on customer
    for each row
begin
	if old.grade != new.grade then
		insert into grade_history (custid, changedate, before_grade, after_grade)
		values (new.custid, curdate(), old.grade, new.grade);
    end if;
end //
delimiter ;

-- 7) order 테이블에 주문 내역이 입력되면 book테이블에 서적 개수를 감소시키는 트리거를 생성한다.
use madang;
drop trigger if exists stockTrg;
delimiter //
create trigger stockTrg
	after insert
    on orders
    for each row
begin
	update book
    set stock = stock - new.bookcount
    where bookid = new.bookid;
end //
delimiter ;

-- 8) 구매실적이 생길 때마다 해당 고객의 등급을 다시계산하여 업데이트하는 트리거를 생성한다.
use madang;
drop trigger if exists updateGradeTrg;
delimiter //
create trigger updateGradeTrg
	after insert
    on orders
    for each row
begin
	declare total double;
    
    select sum(saleprice * bookcount) into total from orders where custid = new.custid;
    
    case
		when total >= 35000 then
			update customer set grade = 'gold' where custid = new.custid;
		when total >= 20000 then
			update customer set grade = 'silver' where custid = new.custid;
		else
			update customer set grade = 'bronze' where custid = new.custid;
	end case;
end //
delimiter ;