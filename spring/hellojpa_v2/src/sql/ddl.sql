CREATE SCHEMA test;

CREATE TABLE test.customer ( 
	id                   bigint  NOT NULL  AUTO_INCREMENT,
	first_name           varchar(255)    ,
	last_name            varchar(255)    ,
	email                varchar(255)    ,
	CONSTRAINT pk_customer PRIMARY KEY ( id )
 );

CREATE TABLE test.address ( 
	id                   bigint  NOT NULL  AUTO_INCREMENT,
	city                 varchar(255)    ,
	country              varchar(255)    ,
	street               varchar(255)    ,
	customer_id          bigint    ,
	CONSTRAINT pk_address PRIMARY KEY ( id ),
	CONSTRAINT `FK93c3js0e22ll1xlu21nvrhqgg` 
		FOREIGN KEY ( customer_id ) 
		REFERENCES test.customer( id ) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
 );

CREATE INDEX FK93c3js0e22ll1xlu21nvrhqgg ON test.address ( customer_id );

