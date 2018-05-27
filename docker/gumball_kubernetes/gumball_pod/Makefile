
all: clean

clean: 
	find . -name 'gumball' -type f -exec rm -f {} \; 
	go clean

run:
	go run src/app/$(app).go

main:
	go run src/app/main.go

format:
	go fmt gumball

install:
	go install gumball

build:
	go build gumball

start:
	./gumball 

test-ping:
	curl localhost:3000/ping

test-gumball:
	curl localhost:3000/gumball

docker-build: 
	docker build -t gumball .
	docker images

docker-run:
	docker run --name gumball -td -p 3000:3000 gumball
	docker ps

docker-network:
	docker network inspect host

docker-shell:
	docker exec -it gumball bash 

docker-clean:
	docker stop gumball
	docker rm gumball
	docker rmi gumball

docker-ip:
	docker-machine ip


kube-context:
	kubectl config set-context gumball --namespace=gumball
	kubectl config use-context gumball

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	 kubectl get pods

pod-desc:
	kubectl describe pods gumball

pod-delete:
	kubectl delete -f pod.yaml

pod-port-foward:
	kubectl port-forward gumball 3000:3000

pod-shell:
	kubectl exec -it gumball -- /bin/bash

pod-logs:
	kubectl logs -f gumball




