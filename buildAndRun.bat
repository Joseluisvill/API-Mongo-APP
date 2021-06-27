@echo off
call mvn clean package
call docker build -t com.mycompany/API-APP .
call docker rm -f API-APP
call docker run -d -p 9080:9080 -p 9443:9443 --name API-APP com.mycompany/API-APP