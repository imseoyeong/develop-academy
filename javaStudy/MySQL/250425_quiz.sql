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


-- 현재 Development 부서에서 근무하는 직원의 이름과 생년월일을 조회
select e.first_name, e.last_name, e.birth_date from employees e
join dept_emp de
on e.emp_no = de.emp_no
join departments dpt
on de.dept_no = dpt.dept_no
where dpt.dept_name = "Development" and de.to_date = "9999-01-01";

-- name이 Christ Muchinsky인 직원의 현재 소속 부서명과 현재 연봉
select e.first_name, e.last_name, dpt.dept_name, s.salary from employees e
join dept_emp de
on e.emp_no = de.emp_no
join departments dpt
on de.dept_no = dpt.dept_no
join salaries s
on e.emp_no = s.emp_no
where e.first_name = "Christ" and e.last_name = "Muchinsky" and s.to_date = "9999-01-01" and de.to_date = "9999-01-01";

-- 현재 title이 Senior Engineer로 일하고 있는 직원의 이름과 연봉
select e.first_name, e.last_name, s.salary from employees e
join titles t
on e.emp_no = t.emp_no
join salaries s
on e.emp_no = s.emp_no
where t.title = "Senior Engineer" and t.to_date = "9999-01-01"
and s.to_date = "9999-01-01";

-- 각 부서별 매니저들의 현재 연봉
select dpt.dept_name, e.first_name, e.last_name, s.salary from departments dpt
join dept_manager dm
on dpt.dept_no = dm.dept_no
join salaries s
on dm.emp_no = s.emp_no
join employees e
on e.emp_no = s.emp_no
where dm.to_date = "9999-01-01" and s.to_date = "9999-01-01";

-- 부서별로 매니저가 바뀐 횟수를 조회 (부셔명, 역대 매니저 수)
select dpt.dept_name, count(*) as 역대매니저수 from departments dpt
join dept_manager dm
on dpt.dept_no = dm.dept_no
group by dpt.dept_no; 