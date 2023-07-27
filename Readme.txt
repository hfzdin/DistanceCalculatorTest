1. Identify the requirement -

Input
-two numbers
-two units
-1 unit for output

Output
-1 numbers with output

web service

Spring Boot REST API,Spring HATEOAS dependency, JDK 17,Maven

2. Create a repo in github

https://github.com/hfzdin/DistanceCalculatorTest

3. Create Spring Boot Rest barebone

-New Spring Starter Project in Eclipse IDE using Spring Rest API,Spring HATEOAS dependecy

4. Write code to accept the three input and the output

-create a controller for the API GET
-the url needs to accept 5 inputs
-test the url validity
-create error message for exception
-test for logic

-create a controller for POST method
-test for logic


URL to call when using GET method - http://localhost:8080/calculate/3/m/5/y/m

URL to call when using POST method - http://localhost:8080/calculate/json

JSON-

{
  "firstVal": 3,
  "firstUnit": "m",
  "secondVal": 5,
  "secondUnit": "m",
  "answerUnit": "m"
}

Future

1. more robust REST API in which in the same controller have GET,POST method
2. proper error messages

