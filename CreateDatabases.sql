DROP TABLE IF EXISTS `team_member`;
DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `team` (
`team_id` int(11) NOT NULL,
`teamname` varchar(45),
PRIMARY KEY (`team_id`)
);
CREATE TABLE `user` (
`user_id` int(11) NOT NULL,
`username` varchar(45),
`password` varchar(45),
`admin` int(11) DEFAULT NULL,
PRIMARY KEY (`user_id`)
);
CREATE TABLE `team_member` (
`team_id` int(11) NOT NULL,
`user_id` int(11) NOT NULL,
PRIMARY KEY (`team_id`,`user_id`),
CONSTRAINT `fk_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
);

insert into team values (1, 'A');
insert into team values (2, 'B');
insert into team values (3, 'C');

insert into user values (1, 'Anders And', 1234, True);
insert into user values (2, 'Mickey Mouse', 5678, True);
insert into user values (3, 'Fedtmule', 1234, false);
insert into user values (4, 'George Gearløs', 1234, false);
insert into user values (5, 'Bedstemor And', 1234, false);
insert into user values (6, 'Onkel Joakim', 1234, false);
insert into user values (7, 'Pluto', 1234, false);
insert into user values (8, 'Fætter Guf', 1234, false);

insert into team_member values (1, 2);
insert into team_member values(1, 3);
insert into team_member values(1, 7);

insert into team_member values(2, 1);
insert into team_member values(2, 4);
insert into team_member values(2, 5);
insert into team_member values(2, 6);
insert into team_member values(2, 8);

insert into team_member values(3, 1);
insert into team_member values(3, 2);
insert into team_member values(3, 3);
insert into team_member values(3, 7);

