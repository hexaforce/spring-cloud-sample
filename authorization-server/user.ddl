CREATE SCHEMA `authentication` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `AUTHORITIES`;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `IX_AUTH_USERNAME` (`username`,`authority`),
  CONSTRAINT `FK_AUTHORITIES_USERS` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- CREATE UNIQUE INDEX IX_AUTH_USERNAME ON authorities( username, authority );
