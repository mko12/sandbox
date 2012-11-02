drop table flashcard;
drop table user_roles;
drop table users;

-- New spring security compliant tables:

CREATE TABLE `USERS` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


CREATE TABLE `USER_ROLE` (
  `user_role_id` int(10) NOT NULL,
  `userid` int(11) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FK_user_role` (`userid`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `FLASHCARD` (
 `fid` int(11) NOT NULL AUTO_INCREMENT,
 `answer` varchar(255) DEFAULT NULL,
 `question` varchar(255) DEFAULT NULL,
 `topic` varchar(255) DEFAULT NULL,
 `userid` int(11) DEFAULT NULL,
 PRIMARY KEY (`fid`),
 KEY `FK_flashcard_user` (`userid`),
 CONSTRAINT `FK_flashcard_user` FOREIGN KEY (`userid`) REFERENCES `USERS` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- inserts updated for spring security
insert into users (userid, username, password, email, enabled)
values(1, 'bob', 'ee11cbb19052e40b07aac0ca060c23ee', 'bob@domain.com', 1);
insert into users (userid, username, password, email, enabled)
values(2, 'tom', '21232f297a57a5a743894a0e4a801fc3', 'tom@org.gov', 1);

INSERT INTO user_role (USER_ROLE_ID, USERID,AUTHORITY)
VALUES (1, 1, 'ROLE_USER');

INSERT INTO user_role (USER_ROLE_ID, USERID,AUTHORITY)
VALUES (2, 2, 'ROLE_ADMIN');

insert into FLASHCARD (fid, question, answer, topic, userid) values(1, 'What is your name?', 'charlton', 'people', 1);
insert into FLASHCARD (fid, question, answer, topic, userid) values(2, 'Who is your boss?', 'myself', 'happy', 2);
insert into FLASHCARD (fid, question, answer, topic, userid) values(3, 'What is the capital of Greece?', 'Athens', 'Geography', 1);
insert into FLASHCARD (fid, question, answer, topic, userid) values(4, 'Hello', 'Hola', 'Languages', 2);
