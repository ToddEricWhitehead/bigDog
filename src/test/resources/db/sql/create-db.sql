--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);


CREATE TABLE students (
	id INTEGER PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
	mobile BIGINT,
	country VARCHAR(45)
);	