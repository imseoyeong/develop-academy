-- 박지성의 고객아이디와 이름, 주소, 구매액, 구매날짜를 조회
select c.custid, c.name, c.address, o.saleprice, o.orderdate
from customer c
join orders o
on c.custid = o.custid
where c.name = "박지성";

-- 고객별로 이름과 주소와 총 구매액을 조회
select c.custid, c.name, c.address, sum(saleprice) as 총구매액
from customer c
join orders o
on c.custid = o.custid
group by c.custid;

-- 유저들의 아이디, 이름, 구매물품, 주소, 연락처를 이름순으로 조회
select u.userid, u.username, b.prodname, u.addr, concat(u.mobile1, u.mobile2) as 연락처
from usertbl u
join buytbl b
on u.userid = b.userid
order by u.username;

-- 경북에 거주하는 유저들의 아이디, 이름, 구매물품, 구매액을 조회
select u.userid, u.username, b.prodname, (b.price * b.amount) as 구매액
from usertbl u
join buytbl b
on u.userid = b.userid
where u.addr = "경북";

-- 경북에 거주하거나 물품 분류가 없는 물건을 구입한 유저들의 아이디, 이름, 구매물품, 주소를 조회
select u.userid, u.username, b.prodname, u.addr
from usertbl u
join buytbl b
on u.userid = b.userid
where u.addr = "경북" or b.groupname is null;

-- 각 지역 별로 평균키보다 큰 사람들의 주소, 이름, 키를 조회
select u1.addr, u1.username, u1.height
from usertbl u1
join (select addr, avg(height) as 평균키 from usertbl group by addr) u2
on u1.addr = u2.addr
where u1.height > u2.평균키;

-- 각 고객이 주문한 도서의 이름들을 조회 (고객 이름, 주문 도서 이름)
select c.name, b.bookname
from customer c
join orders o
on c.custid = o.custid
join book b
on o.bookid = b.bookid;

-- 가격이 20,000원 이상인 도서를 주문한 고객의 이름과 도서의 이름 조회
select c.name, b.bookname
from customer c
join orders o
on c.custid = o.custid
join book b
on o.bookid = b.bookid
where b.price >= 20000;

-- 정가보다 싸게 산 고객의 아이디, 이름, 정가, 구매가격을 조회
select c.custid, c.name, b.price, o.saleprice
from customer c
join orders o
on c.custid = o.custid
join book b
on o.bookid = b.bookid
where b.price > o.saleprice;