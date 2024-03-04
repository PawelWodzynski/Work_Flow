DROP DATABASE IF EXISTS `workflow`;

CREATE DATABASE IF NOT EXISTS `workflow`;
USE `workflow`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is available at: https://bcrypt-generator.com/
--
-- Default passwords here are: admin
--

INSERT INTO `employee` (username, password, first_name, last_name, email)
VALUES 
('admin', '$2a$12$m3ZBICrETR7kXtjOcbEZreRM1MnIcUlZ98QVeb7di4B4fm.sxwHXS', 'Admin', 'Admin', 'admin@admin.com'),
('manager', '$2a$12$m3ZBICrETR7kXtjOcbEZreRM1MnIcUlZ98QVeb7di4B4fm.sxwHXS', 'Test', 'Manager', 'test@manager.com'),
('employee', '$2a$12$m3ZBICrETR7kXtjOcbEZreRM1MnIcUlZ98QVeb7di4B4fm.sxwHXS', 'Test', 'Employee', 'test@employee.com');


--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (name)
VALUES 
('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');

--
-- Table structure for table `employee_roles`
--

DROP TABLE IF EXISTS `employee_roles`;

CREATE TABLE `employee_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
    REFERENCES `employee` (`id`) 
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
    REFERENCES `role` (`id`) 
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `employee_roles`
--

INSERT INTO `employee_roles` (user_id, role_id)
VALUES 
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(3, 1);



CREATE TABLE `todo_date` (
  `id` int NOT NULL AUTO_INCREMENT,
  `month_number` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_EMPLOYEE_idx` (`employee_id`),
  
  CONSTRAINT `FK_EMPLOYEE` 
  FOREIGN KEY (`employee_id`) 
  REFERENCES `employee` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `todo_point` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(256) DEFAULT NULL,
  `point_order` int NOT NULL,
  `from_day_number` int  DEFAULT NULL,  
  `to_day_number` int DEFAULT NULL,
  `completed` BOOLEAN NOT NULL,
  `todo_date_id` int DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_TODO_DATE_ID_idx` (`todo_date_id`),

  CONSTRAINT `FK_TODO_DATE` 
  FOREIGN KEY (`todo_date_id`) 
  REFERENCES `todo_date` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE `todo_extended_point` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(256) DEFAULT NULL,
  `point_order` int NOT NULL,
  `completed` BOOLEAN NOT NULL,
  `todo_point_id` int DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_TODO_POINT_ID_idx` (`todo_point_id`),

  CONSTRAINT `FK_TODO_POINT` 
  FOREIGN KEY (`todo_point_id`) 
  REFERENCES `todo_point` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;







SET FOREIGN_KEY_CHECKS = 1;



