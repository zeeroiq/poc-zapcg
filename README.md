# poc-zapcg
Services:

1. poc-zapcg: 8080
```
POST: /api/v1/producer/dump/csv
```
2. poc-zapcg-consumer: 8081
```
GET: api/v1/consumer/employees
```
3. db-excel-dump: 8082
```
POST: /api/v1/export/employee
```
4. api-gateway: 8989
5. eureka-server: 8761

## DOCKER commands
```
> docker run -it --name mysql -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d --rm mysql
> docker exec -it mysql bash
> mysql -u root -p

Currently around 9600 records will be dumped to DB to test db-excel-dump service directly with the endpoint it might take several mins, so delete some records from DB
> DELETE FROM poc.employee e ORDER BY e.emp_id DESC LIMIT 9500
```


## KAFKA commands
Change dir to kafka path and execute below commands
```
> zookeeper-server-start.bat .\config\zookeeper.properties
> kafka-server-start.bat .\config\server.properties
> kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic EMPLOYEE_TOPIC
```