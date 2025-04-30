drop trigger if exists orderTrg;

delimiter //
create trigger orderTrg
after insert
on orderTBL
for each row
begin
	update prodTBL set account = account - new.orderamount where prodName = new.prodname;
end //
delimiter ;

drop trigger if exists prodTrg;
delimiter //
create trigger prodTrg
after update
on prodTBL
for each row
begin
	declare orderAmount int;
	set orderAmount = old.account - new.account;
	insert into deliverTBL(prodName, account) values(new.prodName, orderAmount);
-- 	signal sqlstate '45000'
-- 		set message_text = "error";
end //
delimiter ;

insert into orderTBL values (null, 'JOHN', '배', 5);
select * from orderTBL;
select * from prodTBL;
select * from deliverTBL;