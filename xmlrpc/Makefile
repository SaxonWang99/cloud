all: compile war deploy

compile: 
	javac -cp /home/ubuntu/workspace/xmlrpc/lib/servlet-api.jar:/home/ubuntu/workspace/xmlrpc/lib/xalan.jar:/home/ubuntu/workspace/xmlrpc/lib/xerces.jar -d /home/ubuntu/workspace/xmlrpc/build/WEB-INF/classes /home/ubuntu/workspace/xmlrpc/source/edu/sjsu/cmpe281/*.java /home/ubuntu/workspace/xmlrpc/source/helma/xmlrpc/*.java
	
war:
	/home/ubuntu/workspace/xmlrpc/genwar.sh
	
deploy:
	rm -rf /home/ubuntu/apache-tomcat/webapps/xmlrpc
	rm -rf /home/ubuntu/apache-tomcat/webapps/xmlrpc.war
	cp /home/ubuntu/workspace/xmlrpc/xmlrpc.war /home/ubuntu/apache-tomcat/webapps
