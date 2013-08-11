Project for testing clustering

1. Build and test for skinny wars:
 
 mvn clean package -P skinny-all

 In ear project:
 
 mvn tomee:run -Pnode1
 
 mvn tomee:run -Pnode2
 
2. Build and test for skinny wars, keeping codi in webapp lib:
 
 mvn clean package -P skinny-codi-in-web 

 In ear project:
 
 mvn tomee:run -Pnode1
 
 mvn tomee:run -Pnode2
