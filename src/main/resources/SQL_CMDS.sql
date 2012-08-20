drop table FLASHCARD;
drop table USER;

create table USER
(
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(2000) NOT NULL,
 password VARCHAR(2000) NOT NULL,
 email VARCHAR(2000)
) ENGINE=INNODB ;

create table FLASHCARD
(
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 question VARCHAR(2000),
 answer VARCHAR(2000),
 topic VARCHAR(2000)
);


insert into user values(1, 'mimika', 'test', 'mimika@domain.com');
insert into user values(2, 'charlton', 'test', 'charlton@domain.com');

insert into FLASHCARD values(1, 'What is your name?', 'charlton', 'people');
insert into FLASHCARD values(2, 'Who is your boss?', 'myself', 'happy');

Foreign key - work in progress so you may have to work with the original tables w/o foreign key until we complete the integration on the JPA level.

create table FLASHCARD
(
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 question VARCHAR(2000) NOT NULL,
 answer VARCHAR(2000) NOT NULL,
 topic VARCHAR(2000) NOT NULL,
 FK_users INT NOT NULL,
 INDEX (FK_users),
 FOREIGN KEY (FK_users) REFERENCES users (id)
)  ENGINE=INNODB ;


insert into user values(1, 'mimika', 'test', 'mimika@domain.com');
insert into user values(2, 'charlton', 'test', 'charlton@domain.com');

insert into FLASHCARD values(1, 'What is your name?', 'charlton', 'people', 1);
insert into FLASHCARD values(2, 'Who is your boss?', 'myself', 'happy', 2);


SELECT * from flashcard;
SELECT * from users;

delete from users;
delete from flashcard;