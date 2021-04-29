
use seleniumexpress;
DROP table students;
create table students (
	id int primary key AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	mobile BIGINT,
	country VARCHAR(45)
);	
INSERT INTO STUDENTS VALUES (1, "SUDHIR", 5123334444, "INDIA");
insert into students values (2, "Priya", 5129991111, "UK");
insert into students values (3, "Justin", 5123451680, "US");
insert into students values (4, "JASMIN", 5125557777, "INDIA");