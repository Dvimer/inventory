CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `role` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `users` (`username`, `password`, `role`, `enabled`) VALUES
	('admin', '12345678', 'ROLE_ADMIN', 1),
	('user', '123', 'ROLE_USER', 1);