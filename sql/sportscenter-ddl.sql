-- USER INFO
CREATE TABLE IF NOT EXISTS `TB_USER_INFO` (
   `USER_NO` INT(11) NOT NULL AUTO_INCREMENT,
   `USER_ID` VARCHAR(50) NOT NULL UNIQUE,
   `USER_NAME` VARCHAR(50) NOT NULL,
   `PASSWORD` VARCHAR(100) NOT NULL,
   `PHONE_NUMBER` VARCHAR(100) NOT NULL,
   `GENDER` VARCHAR(2) NOT NULL,
   `REG_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
   `ADMIN` BIT DEFAULT 0,
   PRIMARY KEY(`USER_NO`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COLLATE UTF8_GENERAL_CI;

select * from tb_user_info;



-- NOTICE INFO
CREATE TABLE IF NOT EXISTS `TB_NOTICE` (
<<<<<<< HEAD
	`BOARD_NO` INT(11) NOT NULL AUTO_INCREMENT,
	`BOARD_TITLE` VARCHAR(150) NOT NULL UNIQUE,
	`BOARD_CONTENT` VARCHAR(2000) NOT NULL,
	`BOARD_WRITER` VARCHAR(50)  NOT null,
	`REG_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
	`UPDATE_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
	PRIMARY KEY(`BOARD_NO`)
=======
   `BOARD_NO` INT(11) NOT NULL AUTO_INCREMENT,
   `BOARD_TITLE` VARCHAR(150) NOT NULL UNIQUE,
   `BOARD_CONTENT` VARCHAR(2000) NOT NULL,
   `BOARD_WRITER` VARCHAR(50)  NOT null,
   `REG_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
   `UPDATE_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
   PRIMARY KEY(`BOARD_NO`)
>>>>>>> 6ccaf922fbb6b4e37d64e9304f4fbf13a6a82bba
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COLLATE UTF8_GENERAL_CI;

SELECT * FROM TB_NOTICE;

insert into tb_notice(board_title, board_content, board_writer) values ('제목','내용','작성자');

-- QNA INFO
CREATE TABLE IF NOT EXISTS `TB_QNA` (
<<<<<<< HEAD
	`QNA_NO` INT(11) NOT NULL AUTO_INCREMENT,
	`QNA_QUESTION` VARCHAR(2000) NOT NULL UNIQUE,
	`QNA_ANSWER` VARCHAR(2000) NOT NULL,
	`QNA_WRITER` VARCHAR(50)  NOT null,
	`REG_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
	PRIMARY KEY(`QNA_NO`)
=======
   `QNA_NO` INT(11) NOT NULL AUTO_INCREMENT,
   `QNA_QUESTION` VARCHAR(2000) NOT NULL UNIQUE,
   `QNA_ANSWER` VARCHAR(2000) NOT NULL,
   `QNA_WRITER` VARCHAR(50)  NOT null,
   `REG_DATE` TIMESTAMP NOT NULL DEFAULT NOW(),
   PRIMARY KEY(`QNA_NO`)
>>>>>>> 6ccaf922fbb6b4e37d64e9304f4fbf13a6a82bba
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COLLATE UTF8_GENERAL_CI;

insert into TB_QNA(QNA_QUESTION, QNA_ANSWER, QNA_WRITER) values ('질문','답변','작성자');

SELECT * FROM TB_QNA;

alter table TB_QNA modify column `QNA_WRITER` VARCHAR(50) null;

alter table TB_QNA add column `QNA_TITLE` VARCHAR(100) not null;

delete from tb_user_info;

select QNA_WRITER
from TB_QNA
where QNA_WRITER ='wnsgml6440';