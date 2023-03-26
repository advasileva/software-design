PID := $(shell lsof -t -i:8000)

build:
	cd server && mvn clean install && cp target/*with-dependencies.jar ../server.jar
	cd client && mvn clean install && cp target/*with-dependencies.jar ../client.jar

server:
	java -jar server.jar

client:
	java -jar client.jar
