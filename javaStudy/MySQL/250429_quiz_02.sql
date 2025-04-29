-- [문제]
-- 고객 할인률이 입력될 새로운 테이블을 만든다. (고객Id, 할인률)
-- 가입한지 15년 이상이거나 총 구매액이 1000을 넘으면 0.15, 가입한지 12년 이상이거나 총 구매액이 500을 넘으면 0.10, 가입한지 10년 이상이거나 총 구매액이 100을 넘으면 0.05, 나머지는 0.0
drop procedure if exists customer_discount_rate;
delimiter //
create procedure customer_discount_rate()
begin     
    declare u_id varchar(10);                     
    declare jdate date;                               
    declare totalprice double;
    declare years int;
    declare rate double;
    declare endofRow boolean default false;
        
	declare user_cursor cursor for
    select u.userid, u.mdate, sum(b.price*b.amount)
    from usertbl u
    left outer join buytbl b
    on u.userid = b.userid
    group by u.userid;
    
	declare continue handler for not found
	set endofRow = true;
    
	drop table if exists discount_rate_tbl;
	create table discount_rate_tbl (
		userid char(8) primary key,     
		discount_rate double                 
	);
    
    open user_cursor;
    
    cursor_loop: loop
		fetch user_cursor into u_id, jdate, totalprice;
        if endofRow then 
			leave cursor_loop;
        end if;
        
        set years = datediff(curdate(), jdate)/365;
        
        case
			when years >= 15 or totalprice >= 1000 then
				set rate = 0.15;
			when years >= 12 or totalprice >= 500 then
				set rate = 0.10;
			when years >= 10 or totalprice >= 100 then
				set rate = 0.05;
			else
				set rate = 0.00;
		end case;
        
		insert into discount_rate_tbl values(u_id, rate);
    end loop cursor_loop;
    
    close user_cursor;
end //
delimiter ;

call customer_discount_rate();
select * from discount_rate_tbl;