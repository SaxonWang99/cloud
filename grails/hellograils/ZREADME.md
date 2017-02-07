## Grails Resources

		http://docs.grails.org/latest/
		http://guides.grails.org/creating-your-first-grails-app/guide/index.html
		https://github.com/grails-guides/creating-your-first-grails-app


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
	 
	grails create-domain-class Vehicle
	grails create-domain-class Make
	grails create-domain-class Model
	
	grails create-controller Home
	grails create-controller Vehicle
	grails create-controller Make
	grails create-controller Model
	
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
	
	---
	
	import hellograils.Vehicle 
	
	def vehicles = Vehicle.list()
	println vehicles.size()

	def pickup = Vehicle.findByName("Pickup")
	println pickup.name
	println pickup.make.name
	println pickup.model.name

	def nissan = Make.findByName("Nissan")
	def nissans = Vehicle.findAllByMake(nissan)
	println nissans.size()



