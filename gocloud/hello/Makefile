
all: clean

clean: 
	find . -name 'hello' -type f -exec rm -f {} \;
	go clean

build:
	go build github.com/cloudnativego/hello

run:
	go run src/github.com/cloudnativego/hello/main.go

format:
	go fmt github.com/cloudnativego/hello

install:
	go install github.com/cloudnativego/hello


