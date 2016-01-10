##  Slim
##  a micro framework for PHP

    http://www.slimframework.com/ 
    https://getcomposer.org/
    http://www.sitepoint.com/best-practices-rest-api-scratch-introduction/

    
## Install Commands

    curl -sS https://getcomposer.org/installer | php
    php composer.phar create-project slim/slim-skeleton hello-slim
    
    
## Install Results

       paulnguyen:~/workspace/php (master) $ curl -sS https://getcomposer.org/installer | php
        #!/usr/bin/env php
        All settings correct for using Composer
        Downloading...
        Composer successfully installed to: /home/ubuntu/workspace/php/composer.phar
        Use it: php composer.phar
       
        paulnguyen:~/workspace/php (master) $ php composer.phar create-project slim/slim-skeleton hello-slim
        You are running composer with xdebug enabled. This has a major impact on runtime performance. See https://getcomposer.org/xdebug
        Installing slim/slim-skeleton (3.0.0)
          - Installing slim/slim-skeleton (3.0.0)
            Downloading: 100%         
        
        Created project in hello-slim
        Loading composer repositories with package information
        Installing dependencies (including require-dev) from lock file
          - Installing psr/log (1.0.0)
            Downloading: 100%         
        
          - Installing monolog/monolog (1.17.2)
            Downloading: 100%         
        
          - Installing psr/http-message (1.0)
            Downloading: 100%         
        
          - Installing slim/php-view (2.0.5)
            Downloading: 100%         
        
          - Installing pimple/pimple (v3.0.2)
            Downloading: 100%         
        
          - Installing nikic/fast-route (v0.6.0)
            Downloading: 100%         
        
          - Installing container-interop/container-interop (1.1.0)
            Downloading: 100%         
        
          - Installing slim/slim (3.0.0)
            Downloading: 100%         
        
        monolog/monolog suggests installing aws/aws-sdk-php (Allow sending log messages to AWS services like DynamoDB)
        monolog/monolog suggests installing doctrine/couchdb (Allow sending log messages to a CouchDB server)
        monolog/monolog suggests installing ext-amqp (Allow sending log messages to an AMQP server (1.0+ required))
        monolog/monolog suggests installing ext-mongo (Allow sending log messages to a MongoDB server)
        monolog/monolog suggests installing graylog2/gelf-php (Allow sending log messages to a GrayLog2 server)
        monolog/monolog suggests installing php-console/php-console (Allow sending log messages to Google Chrome)
        monolog/monolog suggests installing raven/raven (Allow sending log messages to a Sentry server)
        monolog/monolog suggests installing rollbar/rollbar (Allow sending log messages to Rollbar)
        monolog/monolog suggests installing ruflin/elastica (Allow sending log messages to an Elastic Search server)
        monolog/monolog suggests installing videlalvaro/php-amqplib (Allow sending log messages to an AMQP server using php-amqplib)
        Generating autoload files
        


