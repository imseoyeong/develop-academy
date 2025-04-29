-- 1) book table에 저장된 도서들의 평균 값을 out용 매개변수로 전달하는 프로시저
-- DROP PROCEDURE IF EXISTS averageprice;
-- delimiter //
-- create procedure averageprice(out avg_price double)
-- begin
-- 	select avg(price) into avg_price from book;
-- end //
-- delimiter ;

-- call averageprice(@avgprice);
-- select @avgprice;

-- 2) 동일한 도서가 있는지 점검한 후 삽입하는 프로시저
-- drop procedure if exists book_insert_update;
-- delimiter //
-- create procedure book_insert_update(
-- 	in p_bookname varchar(20),
-- 	in p_publisher varchar(10),
-- 	in p_price int
-- )
-- begin
-- 	declare cnt int;
--     
--     select count(*) into cnt from book where bookname = p_bookname;
--     
--     if cnt = 0 then
-- 		insert into book values(null, p_bookname, p_publisher, p_price);
-- 	else
-- 		update book set publisher = p_publisher, price = p_price where bookname = p_bookname;
-- 	end if;
-- end //
-- delimiter ;

-- call book_insert_update('sns', '대한미디어', 15000);
-- select * from book;

-- 3) 각 출판사와 최고가(MAX), 최저가(MIN) 중 하나를 입력하면 그에 해당하는 책의 가격을 out 매개변수로 전달하는 프로시저 구현
drop procedure if exists getbookprice;
delimiter //
create procedure getbookprice(
	in p_publisher varchar(20),
	in p_type char(3),
	in p_price int
)
begin
	if p_type = 'MAX' then
		select MAX(price) into p_price from book where publisher = p_publisher;
	elseif p_type = 'MIN' then
		select MIN(price) into p_price from book where publisher = p_publisher;
	end if;
end //
delimiter ;

call getbookprice('나무수', 'MAX', @bkprice);
select * from book;