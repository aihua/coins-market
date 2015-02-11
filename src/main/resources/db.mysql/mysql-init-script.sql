CREATE DATABASE `coinsmarket`;

USE coinsmarket;

CREATE TABLE `coin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) NOT NULL,
  `composition` varchar(50) NOT NULL,
  `year` integer(4) NOT NULL,
  `circulation` integer NOT NULL,
  `grade` varchar(50) NOT NULL,
  `price` decimal NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;