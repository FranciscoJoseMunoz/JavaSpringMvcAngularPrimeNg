CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passport` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into people (id, passport, firstname, lastname) values (0, 'AAA111', 'John', 'Doe');
insert into people (id, passport, firstname, lastname) values (0, 'BBB222', 'Jane', 'Doe');