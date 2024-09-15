CREATE DATABASE IF NOT EXISTS student_tracker;
-- show databases;
USE student_tracker;

DROP TABLE IF EXISTS student;

CREATE TABLE student(
	id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) DEFAULT NULL,
    last_name VARCHAR(50) DEFAULT NULL,
    email VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


