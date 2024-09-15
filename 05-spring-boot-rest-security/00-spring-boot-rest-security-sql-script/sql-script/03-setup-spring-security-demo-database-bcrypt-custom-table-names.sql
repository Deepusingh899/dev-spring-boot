use `employee_tracker`;

Drop Table if exists `members`;
drop table if exists `roles`;

-- Create a table Structure for `Members` Table

create table `members` (
	`user_id` varchar(50) not null,
    `pwd` varchar(68) not null,
    `active` tinyint not null,
    
    primary key(`user_id`)
)engine=InnoDB default charset=latin1;

-- Insert the data into users table
-- Note: the password should be encrypt by using Bcrytp
-- a generation tool is available at : "https://www.luv2code.com/generate-bcrypt-password"
-- default password are here : fun123

Insert into `members` values
			('john','{bcrypt}$2a$10$8r4QeGt.Laf7jG/qSuHUj.8wCtzYO/Qc0XiMMx/4hywpR2g.BXUZy',1),
            ('mary','{bcrypt}$2a$10$8r4QeGt.Laf7jG/qSuHUj.8wCtzYO/Qc0XiMMx/4hywpR2g.BXUZy',1),
            ('susan','{bcrypt}$2a$10$8r4QeGt.Laf7jG/qSuHUj.8wCtzYO/Qc0XiMMx/4hywpR2g.BXUZy',1);
            
-- Table Structure for authorities table
Create Table `roles` (
	`user_id` varchar(50) not null,
    `role` varchar(50) not null,
    unique key `authorities_idx_1`(`user_id`,`role`),
    constraint `authorities4_ibfk_1` foreign key(`user_id`) references `members`(`user_id`)
)Engine=InnoDB Default Charset=latin1;

-- Insert Data in to authorities table
Insert into `roles` values
		('john','ROLE_EMPLOYEE'),
        ('mary','ROLE_EMPLOYEE'),
        ('mary','ROLE_MANAGER'),
        ('susan','ROLE_EMPLOYEE'),
        ('susan','ROLE_MANAGER'),
        ('susan','ROLE_ADMIN');
    