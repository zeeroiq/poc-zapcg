# poc-zapcg
Services:

> poc-zapcg [poc]
>> producer service, reads data from file and dump it to kafka broker for other services for consumption

> poc-zapcg-consumer[employee-consumer] 
>> Reads data from EMPLOYEE_TOPIC and insert it to db 
