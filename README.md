
# DevOps Automatic Monitoring Server with Automated Testing

## DevOps Automatic Monitoring Server
That project creates a web server using the Spring Boot framework, implements logging functionality,
integrates an H2 database, and automates the project build process using Maven. 
This server allows users to retrieve logs and create new transactions, which are stored in the database. 
The server also includes a seed class to initialize a log entry when the server starts.

### Prerequisites
* Java Development Kit (JDK) installed
* Maven installed
* H2 database
* Setup Instructions
* Clone the project repository:


git clone <repository_url>
Navigate to the project directory:

```
cd project-directory
```
Build the project using Maven:

```
mvn clean install
```
Start the server:

```
java -jar target/server.jar
```
Access the server at http://localhost:8080

### Routes
GET /logs: Retrieves all logs from the server.

POST /createLog: Creates a new log entry.

## Part 2 - Automated Testing with Python

Automated tests for the DevOps Automatic Monitoring Server using Python. 
These tests ensure the correct functionality of the server and validate the responses to different types of requests.

### Prerequisites
* Python installed
* behave library installed (pip install behave)
* Running DevOps Automatic Monitoring Server (Part 1)
Test Instructions
Ensure that the DevOps Automatic Monitoring Server (Part 1) is running.

Navigate to the tests directory:

```
cd logs-test
```
Run the tests using Behave:
```
behave
```
### Test Scenarios
#### Scenario: Retrieve logs from the server 

Given the web server is running 

When a GET request is made to "/logs"

Then the response status code should be 200 

And the response format should be JSON 

And the response should contain logs 

#### Scenario: Create a new transaction 

Given the web server is running 

When a POST request is made to "/createLog" 

Then the response status code should be 200 

And the response format should be JSON 

And the response should contain a log entry 
