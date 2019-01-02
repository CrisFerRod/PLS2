
CREATE DATABASE `proyectos`;
USE `proyectos`;

CREATE TABLE `users`(
   `user_id` varchar(20) NOT NULL,
   `password` char(64) NOT NULL,
   PRIMARY KEY (`user_id`)
);

CREATE TABLE `roles` (
   `user_id` varchar(20) NOT NULL,
   `role` varchar(20) NOT NULL,
   PRIMARY KEY (`user_id`,`role`)
);

CREATE TABLE `proyectos`(
   `pr_id` int(10) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(50) NOT NULL,
   PRIMARY KEY (`pr_id`)
);

CREATE TABLE `tareas`(
   `ta_id` int(10) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(50) NOT NULL,
   `pr_id` int(10) NOT NULL,
   `fechalimite` DATE NOT NULL,
   `user_id` varchar(20) NOT NULL,
   `fechafinalizacion` DATE,
   PRIMARY KEY (`ta_id`)
);

GRANT ALL ON proyectos.* TO 'webapp'@'localhost' identified by 'webapppasswd';

