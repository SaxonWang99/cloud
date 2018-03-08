

# Docker - Go Gumball API (Deployment Options)

* https://github.com/paulnguyen/cmpe281/tree/master/docker/gumball_makefile
* https://github.com/paulnguyen/cmpe281/tree/master/docker/gumball_compose
* https://github.com/paulnguyen/cmpe281/tree/master/docker/gumball_dockercloud


## Docker Build CLI

* https://docs.docker.com/edge/engine/reference/commandline/docker/
* https://docs.docker.com/edge/engine/reference/commandline/build/

## Docker Compose

* https://docs.docker.com/compose/overview/

## Docker Cloud Stack

* https://docs.docker.com/docker-cloud/apps/stacks/

## Install Go

* https://golang.org/doc/install

## Take a Tour of Go

* https://tour.golang.org/list


# Go Gumball Sample Code

## Go Data Types

```
package main

type gumballMachine struct {
	Id             	int 	
	CountGumballs   int    	
	ModelNumber 	string	    
	SerialNumber 	string	
}

type order struct {
	Id             	string 	
	OrderStatus 	string	
}

var orders map[string] order
```

## Go Main Entry Point

```
package main

import (
	"os"
)

func main() {

	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "3000"
	}

	server := NewServer()
	server.Run(":" + port)
}
```

## Go API Server

```
// MongoDB Config
var mongodb_server = "mongodb"
var mongodb_database = "cmpe281"
var mongodb_collection = "gumball"

// RabbitMQ Config
var rabbitmq_server = "rabbitmq"
var rabbitmq_port = "5672"
var rabbitmq_queue = "gumball"
var rabbitmq_user = "guest"
var rabbitmq_pass = "guest"

// NewServer configures and returns a Server.
func NewServer() *negroni.Negroni {
	formatter := render.New(render.Options{
		IndentJSON: true,
	})
	n := negroni.Classic()
	mx := mux.NewRouter()
	initRoutes(mx, formatter)
	n.UseHandler(mx)
	return n
}

// API Routes
func initRoutes(mx *mux.Router, formatter *render.Render) {
	mx.HandleFunc("/ping", pingHandler(formatter)).Methods("GET")
	mx.HandleFunc("/gumball", gumballHandler(formatter)).Methods("GET")
	mx.HandleFunc("/gumball", gumballUpdateHandler(formatter)).Methods("PUT")
	mx.HandleFunc("/order", gumballNewOrderHandler(formatter)).Methods("POST")
	mx.HandleFunc("/order/{id}", gumballOrderStatusHandler(formatter)).Methods("GET")
	mx.HandleFunc("/order", gumballOrderStatusHandler(formatter)).Methods("GET")
	mx.HandleFunc("/orders", gumballProcessOrdersHandler(formatter)).Methods("POST")
}
```
