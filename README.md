# poc-zapcg
Services:

1. poc-zapcg: 8080
2. poc-zapcg-consumer: 8081
3. db-excel-dump: 8082
4. api-gateway: 8989
5. eureka-server: 8761

## DOCKER commands
<code>
> docker run -it --name mysql -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d --rm mysql <br>
> docker exec -it mysql bash <br>
> mysql -u root -p
</code>

## KAFKA commands
Change dir to kafka path and execute below commands
<code>
> zookeeper-server-start.bat .\config\zookeeper.properties <br>
> kafka-server-start.bat .\config\server.properties <br>
> kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic EMPLOYEE_TOPIC
</code>