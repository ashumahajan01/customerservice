# customerservice

Spring boot microservice to maintain customer data.

This project was generated with Java 11.

	Java 11
	Spring Boot 2.6 
	Maven 
	STS 4.13


Make sure to install all the required packages/software with specified version as mention above before running this application.

### Features ###

This service provides the following functionality
	
	1. Add Customer		
	2. Get list of all customers	
	3. Get list of all customers by first name or last name or first name and last name		
	4. Modify customer address	
	
	
# Below are the list of enpoints
	1. http://localhost:8080/customerapi/addcustomer - for adding customer
	2. http://localhost:8080/customerapi/customers   - get all customers 
	3. http://localhost:8080/customerapi/searchcustomers - search customer by using either firstname or lastname or both
	4. http://localhost:8080/customerapi/updateaddress/custid - modify particular customer address by giving custtomer id in path
	
# Testing
	Clone the project into your system and import as maven project into Spring Tool Suit
	Run as Spring Boot App. The project will run on localhost on port number 8080. 
	The particular endpoint can be tested using postman by sending proper json data to api.
	
	1. Add Customer - POST Method
		Below is the json data need to send with request:		
		{
		  "firstName":"David",
		    "lastName":"Johns",
		    "age":"40",
		    "address":{
		        "streetName" : "Louis Henriastrrat",
		        "streetNumber" : "75",
		        "zipCode" : "2595TN",
		        "city" : "Paris",
		        "country" : "France"
			}
		} 
		
	2. Search Customer - GET Method 
		Below is the json data need to send with request with any combination of first name or last name:
		{
		    "firstName" : "David",
		    "lastName" : ""
		} 

	3. Update address - PUT method
		Below is the json data need to send with request.  Make sure to add correct customer id in path by checking into the database. 
	 	{	   
	        "streetName": "Andre",
	        "streetNumber": "751",
	        "zipCode": "2274TN",
	        "city": "Hague",
	        "country": "Netherland"
		}	
		
# DB and project configuration
	spring.datasource.url=jdbc:h2:mem:customerdb
	spring.datasource.driverClassName=org.h2.Driver
	spring.datasource.username=sa
	spring.datasource.password=123
		 
	spring.jpa.show-sql=true
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
	spring.jpa.hibernate.ddl-auto= update
	spring.h2.console.enabled=true
	spring.h2.console.path=/h2-ui
	
	To open the dabase hit below url in browser
	http://localhost:8080/h2-ui/
	username : sa
	password : 123
	
		
		

		
		
	



