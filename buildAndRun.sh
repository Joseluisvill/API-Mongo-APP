#!/bin/sh
mvn clean package && docker build -t com.mycompany/API-APP .
docker rm -f API-APP || true && docker run -d -p 9080:9080 -p 9443:9443 --name API-APP com.mycompany/API-APP