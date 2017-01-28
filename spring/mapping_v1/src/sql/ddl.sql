
/*
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `test`;

CREATE TABLE IF NOT EXISTS `test`.`student` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(128) NOT NULL,
  `last_name` VARCHAR(128) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
*/

CREATE SCHEMA test;

CREATE TABLE test.student ( 
	id                   bigint  NOT NULL  AUTO_INCREMENT,
	first_name           varchar(255)    ,
	last_name            varchar(255)    ,
	age                  int    ,
	CONSTRAINT pk_customer PRIMARY KEY ( id )
 );

