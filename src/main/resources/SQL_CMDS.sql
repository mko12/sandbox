drop table flashcard;
drop table users;

create table USERS
(
 userid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(2000) NOT NULL,
 password VARCHAR(2000) NOT NULL,
 email VARCHAR(2000)
) ENGINE=INNODB ;

create table FLASHCARD
(
 fid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 question VARCHAR(2000) NOT NULL,
 answer VARCHAR(2000) NOT NULL,
 topic VARCHAR(2000) NOT NULL,
 FK_users INT NOT NULL,
 INDEX (FK_users),
 FOREIGN KEY (FK_users) REFERENCES users (userid)
)  ENGINE=INNODB ;


insert into USERS values(1, 'mimika', 'test', 'mimika@domain.com');
insert into USERS values(2, 'charlton', 'test', 'charlton@domain.com');

insert into FLASHCARD values(1, 'What is your name?', 'charlton', 'people', 1);
insert into FLASHCARD values(2, 'Who is your boss?', 'myself', 'happy', 2);


select * from flashcard;
select * from users;
