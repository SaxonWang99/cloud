
## MONGODB ON CLOUD9

    https://docs.c9.io/v1.0/docs/setup-a-database
    
## First, install MongoDB by running the following command from the Terminal:

    sudo apt-get install -y mongodb-org

## Then, from the terminal, run the following command to start Mongo:

    mongod --bind_ip=$IP --nojournal

    The output will include:
    ...
    waiting for connections on port 27017

## Now you can open the mongo shell in a new Terminal, running following command:

    mongo

## To stop the MongoDB instance press Control + C in the Terminal where mongod 
## is running. Now have a look at the currently used database:

    $ mongo
    mongo> db
    test

## Mongo DB Shell

    https://docs.mongodb.com/manual/reference/mongo-shell/
    
    