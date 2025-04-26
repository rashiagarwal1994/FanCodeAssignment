# FanCode Users Todo Completion Test

## Objective
Ensure all users in the FanCode city (lat between -40 and 5, long between 5 and 100) have completed more than 50% of their tasks.

## Tech Stack
- Java 17
- Maven
- RestAssured
- TestNG

## Setup Instructions
1. Clone the repo:
   ```bash
   git clone https://github.com/rashiagarwal1994/FanCodeAssignment.git

2. Run:
   ``` 
   mvn clean install

3. Goto
   ``` 
   src/test/java/com/fancode/tests/UserTaskTest.java
   
   and run the test case "verifyFanCodeUsersTodoCompletion"

4.  A report folder will be created in parallel to src/ folder. 
5. Open the report in a browser to view the test results.
