
# Setup PHP on AWS EC2 Instance

    http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/install-LAMP.html
    
# Setup Key Pair for EC2 and Download PEM file

    $ ls -l ec2php.pem 
    -rw-r--r--@ 1 pnguyen  staff  1692 Feb 21 18:01 ec2php.pem

    $ chmod go-r ec2php.pem 

    $ ls -l ec2php.pem 
    -rw-------@ 1 pnguyen  staff  1692 Feb 21 18:01 ec2php.pem

# PEM Usage on Mac OS X
    
    ec2.sh:
        ssh -i ec2php.pem ec2-user@<PUBLIC_IP> 
    scp.sh:
        scp -i ec2php.pem $1 ec2-user@<PUBLIC_IP>:/tmp 

    $ chmod +x *.sh
