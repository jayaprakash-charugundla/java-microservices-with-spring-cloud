http://localhost:8761/

http://localhost:8081/dashboard  
http://localhost:8081/dashboard?stationId=1001  
http://localhost:8081/dashboard?stationId=1002  

http://localhost:8082/customerdetails?fastpassid=800  
http://localhost:8082/customerdetails?fastpassid=801  
http://localhost:8082/customerdetails?fastpassid=802  


http://localhost:8081/actuator/circuitbreakers  
http://localhost:8081/actuator/circuitbreakerevents  

http://localhost:9090/targets  

http://localhost:3000  
admin/admin  

Setup datasource
----------------
Configuration -> Data sources -> Add data source -> Prometheus   
Import json file  

http://localhost:8080/tollrate/1003  

http://localhost:8080/v1/tollrate/1001  
http://localhost:8080/v2/tollrate/1001  

docker run -d --hostname local-rabbit --name pluralsight-rmq -p 15672:15672 -p 5672:5672 rabbitmq:3.9.9-management  
http://localhost:15672  
guest/guest  

Add a new exchange
------------------
name: fastpassprocessor  
type: topic  

Add a new queue
---------------
type: Classic
Name: statusqueue  

statusqueue -> Bindings
-----------------------
From exchange: fastpassprocessor  
Routing key: #  

Config server
-------------
http://localhost:8888/app1/default  
http://localhost:8888/app2/default  
http://localhost:8888/app3/default  

http://localhost:8888/s1rates/default/master  
http://localhost:8888/s1rates/dev/master  
http://localhost:8888/s2rates/default/master  

http://localhost:8888/s1rates/perf/master  
http://localhost:8888/s3rates/perf/master  





