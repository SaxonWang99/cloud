## Grails Resources

		http://docs.grails.org/latest/
		http://gorm.grails.org/6.0.x/hibernate/manual/#domainClasses
		http://gorm.grails.org/6.0.x/hibernate/manual/#constraints
		http://gorm.grails.org/6.0.x/hibernate/manual/#ormdsl
		http://sergiodelamo.es/log-sql-grails-3-app/

## Local Environment Setup

		sdk ls groovy
		sdk ls grails
	   	sdk install groovy 2.4.7
	   	sdk install grails 3.2.5
	   	sdk current

	   	grails --version
	    
		| Grails Version: 3.2.5
		| Groovy Version: 2.4.7
		| JVM Version: 1.8.0_112
		
	    
## Grails Commands
	 
	grails create-domain-class Book

	grails create-domain-class Face0	
	grails create-domain-class Nose0	
	grails create-domain-class Face1	
	grails create-domain-class Nose1	
	grails create-domain-class Face2	
	grails create-domain-class Nose2	

	grails create-domain-class XXX	

	grails run-app
	grails run-app --port=8090
	grails test run-app
	
	grails test-app
	grails test-app -unit
	grails test-app -integration


## Grails H2 DB Console

	http://localhost:8080/dbconsole 
	jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE
	

## Grails Console

	grails console
	grails test console

## MySQL Schema

CREATE TABLE gumball (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  version bigint(20) NOT NULL,
  count_gumballs int(11) NOT NULL,
  model_number varchar(255) NOT NULL,
  serial_number varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY serial_number (serial_number)
) ;

insert into gumball ( id, version, count_gumballs, model_number, serial_number ) 
values ( 1, 0, 1000, 'M102988', '1234998871109' ) ;

select * from gumball ;




