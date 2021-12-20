# Spring-Boot Firebase Crud project
 - Create project in firebase then go to project setting then service account and get the json file and save it into the resources folder


 - Create Employee

   curl --location --request POST 'localhost:8080/employee' \
   --header 'Content-Type: application/json' \   
   --data-raw '{
   "document_id":3,
   "name":"ali",
   "age": 33
   }'


 - Get Employee by document-id
   
curl --location --request GET 'localhost:8080/employee/1' 
   

 - Update Employee Data by document-id

   curl --location --request PUT 'localhost:8080/employee/3' \
   --header 'Content-Type: application/json' \   
   --data-raw '{
   "name":"ahmed",
   "age": 44
   }'
   

 - Delete Employee by document-id
   
   curl --location --request DELETE 'localhost:8080/employee/3'
   