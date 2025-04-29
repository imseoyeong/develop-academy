-- use cookdb;
-- drop function if exists getAgeFunc;
-- delimiter //
-- create function getAgeFunc(bYear int)
-- 	returns int
-- begin
-- 	declare age int;
-- 	return age;
-- end //
-- delimiter ;

-- select userFunc(100, 200);

-- 판매된 도서에 대한 이익을 계산하는 함수 (가격이 30,000원 이상이면 10%, 30,000원 미만이면 5%)
use madang;

drop function if exists fnc_profit;
delimiter //
create function fnc_profit(price int)
returns double
begin
	declare profit double;
    if price >= 30000 then set profit = price * 0.1;
    else
		set profit = price * 0.05;
	end if;
    return profit;
end //
delimiter ;

select bookname, price, fnc_profit(price) as 이익 from book;

