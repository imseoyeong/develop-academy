-- USE cookDB;
-- DROP TABLE IF EXISTS myTable;
-- CREATE TABLE myTable (id INT AUTO_INCREMENT PRIMARY KEY, mDate DATETIME);
-- SET @curDATE = CURRENT_TIMESTAMP(); -- 현재 날짜와 시간
-- PREPARE myQuery FROM 'INSERT INTO myTable VALUES(NULL, ?)';
-- EXECUTE myQuery USING @curDATE;
-- DEALLOCATE PREPARE myQuery;
-- SELECT * FROM myTable;

set @min = 180;
set @max = 190;
prepare myquery from 'select * from usertbl where height between ? and ?';
execute myquery using @min, @max;