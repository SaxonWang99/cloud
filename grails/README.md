     ,-----.,--.                  ,--. ,---.   ,--.,------.  ,------.
    '  .--./|  | ,---. ,--.,--. ,-|  || o   \  |  ||  .-.  \ |  .---'
    |  |    |  || .-. ||  ||  |' .-. |`..'  |  |  ||  |  \  :|  `--, 
    '  '--'\|  |' '-' ''  ''  '\ `-' | .'  /   |  ||  '--'  /|  `---.
     `-----'`--' `---'  `----'  `---'  `--'    `--'`-------' `------'
    ----------------------------------------------------------------- 


# Groovy SDK Setup

http://www.groovy-lang.org/download.html

    curl -s get.sdkman.io | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    sdk install groovy
    groovy -version

# Grails Setup

https://grails.org/wiki/installation

    sdk install grails 2.4.3
    grails -version

# MySQL Setup for Grails Apps

    CREATE DATABASE CMPE281 ;
    CREATE USER 'cmpe281'@'%' IDENTIFIED BY 'cmpe281';
    GRANT ALL PRIVILEGES ON *.* TO 'cmpe281'@'%' WITH GRANT OPTION;
    
# Install Table for Grails Gumball Examples

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
    values ( 1, 0, 10, 'M102988', '1234998871109' ) ;

    select * from gumball ;


# Grail Example Apps (on localhost)

    http://localhost:8080/GrailsHelloWorldVer1
    http://localhost:8080/GrailsGumballMachineVer1
    http://localhost:8080/GrailsGumballMachineVer2
    http://localhost:8080/GrailsRestServiceVer1
    http://localhost:8080/GrailsRestServiceVer2

# Grail Example Apps (on C9)

    http://cloud-paulnguyen.c9users.io:8080/GrailsHelloWorldVer1
    http://cloud-paulnguyen.c9users.io:8080/GrailsGumballMachineVer1
    http://cloud-paulnguyen.c9users.io:8080/GrailsGumballMachineVer2
    http://cloud-paulnguyen.c9users.io:8080/GrailsRestServiceVer1
    http://cloud-paulnguyen.c9users.io:8080/GrailsRestServiceVer2
