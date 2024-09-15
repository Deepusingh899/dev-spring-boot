use `employee_tracker`;

Drop Table if Exists `authorities`;
Drop Table if Exists `users`;

-- Table structure of Users
Create Table `users` (
	`username` varchar(50) not null,
    `password` varchar(68) not null,
    `enabled` tinyint not null,
    
    primary key(`username`)
)Engine=InnoDB Default charset=latin1;

-- Insert the data into users table
-- Note: the password should be encrypt by using Bcrytp
-- a generation tool is available at : "https://www.luv2code.com/generate-bcrypt-password"
-- default password are here : fun123

Insert into `users` values
			('john','{bcrypt}$2a$10$8r4QeGt.Laf7jG/qSuHUj.8wCtzYO/Qc0XiMMx/4hywpR2g.BXUZy',1),
            ('mary','{bcrypt}$2a$10$8r4QeGt.Laf7jG/qSuHUj.8wCtzYO/Qc0XiMMx/4hywpR2g.BXUZy',1),
            ('susan','{bcrypt}$2a$10$8r4QeGt.Laf7jG/qSuHUj.8wCtzYO/Qc0XiMMx/4hywpR2g.BXUZy',1);
            
-- Table Structure for authorities table
Create Table `authorities` (
	`username` varchar(50) not null,
    `authority` varchar(50) not null,
    unique key `authorities_idx_1`(`username`,`authority`),
    constraint `authorities4_ibfk_1` foreign key(`username`) references `users`(`username`)
)Engine=InnoDB Default Charset=latin1;

-- Insert Data in to authorities table
Insert into `authorities` values
		('john','ROLE_EMPLOYEE'),
        ('mary','ROLE_EMPLOYEE'),
        ('mary','ROLE_MANAGER'),
        ('susan','ROLE_EMPLOYEE'),
        ('susan','ROLE_MANAGER'),
        ('susan','ROLE_ADMIN');
        
            
