

       __|  __|_  )
       _|  (     /   Amazon Linux AMI
      ___|\___|___|

https://aws.amazon.com/amazon-linux-ami/2015.09-release-notes/


# Reference:

    https://dev.mysql.com/doc/refman/5.6/en/ha-vm-aws-setup.html
    
# Setup Steps:

    http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/install-LAMP.html

    sudo yum update -y
    sudo yum install -y mysql55-server
    sudo service mysqld start
    /usr/libexec/mysql55/mysql_secure_installation
    
# Allow Remote Access:

    https://easyengine.io/tutorials/mysql/remote-access/

    CREATE DATABASE CMPE281;    
    CREATE USER 'USERNAME' IDENTIFIED BY 'USERNAME';
    GRANT ALL PRIVILEGES ON *.* TO 'USERNAME'@'%' IDENTIFIED BY 'USERNAME' WITH GRANT OPTION;
    SELECT * from information_schema.user_privileges where grantee like "'USERNAME'%";
    FLUSH PRIVILEGES;
    REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'USERNAME'@'%';

    

    
    
    