-- Create the Databse
Create database if not exists employee_tracker;

-- use the Database
use employee_tracker;

-- drop the table if exists
drop Table if exists employee;

-- Create the Table
create table employee(
	id int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) Default null,
    primary key (id)
) Engine=InnoDB Auto_Increment=1 Default charset=latin1;


-- Insert the Data into the table
Insert into employee Values
	(1,'Deepak','Singh','deepusingh@gmail.com'),
    (2,'Deepali','Yadav','deepulisingh@gmail.com'),
    (3,'Shree','Kant','sksingh@gmail.com'),
    (4,'Himmu','Pratap','himmuPratap@gmail.com');