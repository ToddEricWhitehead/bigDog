SHOW DATABASES;
DROP DATABASE seleniumexpress;
CREATE DATABASE seleniumexpress;
use seleniumexpress;
SHOW DATABASES;
CREATE TABLE tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    start_date DATE,
    due_date DATE,
    status TINYINT NOT NULL,
    priority TINYINT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

drop database school;
create database school;
use school;
create table student (
rool_no int primary key,
student_name varchar(45) null,
student_address varchar(45) null
);

use seleniumexpress;
create table students (
	id int primary key AUTO INCREMENT,
	name VARCHAR(45) NOT NULL,
	mobile BIGINT(12),
	country VARCHAR(45)
);	
	
INSERT INTO STUDENTS VALUES (1, "SUDHIR", 5123334444, "INDIA");
insert into students values (2, "Priya", 5129991111, "UK");
insert into students values (3, "Justin", 5123451680, "US");
insert into students values (4, "JASMIN", 5125557777, "INDIA");



use seleniumexpress;
DROP table students;
create table students (
	id int primary key AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	mobile BIGINT(12),
	country VARCHAR(45)
);	
INSERT INTO STUDENTS VALUES (1, "SUDHIR", 5123334444, "INDIA");
insert into students values (2, "Priya", 5129991111, "UK");
insert into students values (3, "Justin", 5123451680, "US");
insert into students values (4, "JASMIN", 5125557777, "INDIA");
