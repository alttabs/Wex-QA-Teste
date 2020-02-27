![Java](https://img.shields.io/badge/BuildWith-JAVA-red)
![test](https://img.shields.io/badge/selenium-tests-green)
![maven](https://img.shields.io/badge/maven-4.0-blue)
![maven](https://img.shields.io/badge/cucumber-DB-green)


![WEX](https://www.wexinc.com/wp-content/uploads/2018/08/logo-WEX.png)


# Wex-QA-Teste
Challenge for QA Automation Analist JR 


## Session 1 - Programming Logic
programming logic problems

## Session 2 - Test Automation
Interface test automation with Selenium and Cucumber

```feature
Scenario: WEX Brazil QA Test
 Given I navigate to “www.amazon.com”.
 When I select the option “Books” in the dropdown next to the search
text input criteria.
 Then I search for “Test automation”.
 And I select the cheapest book of the page without using any sorting
method available.
 When I reach the detailed book page, I check if the na
```
### dependencies
- cucumber-java
- cucumber-junit
- selenium-java

### run
install depedencies and run the ``.feature`` file as a test

## Session 3 - API & DB 

Created API to automate test scenarios

#### User entitie

| Field         | Description                    | Type    | 
| ------------  | ------------------------------ | ------  | 
| id            | user id                        | INTEGER |  
| firstName     | user first name                | STRING  |   
| lastName      | user last name                 | STRING  |  
| movieId        | movie rented                  | INTEGER |   


#### Movie entitie
| Field         | Description                    | Type    | 
| ------------  | ------------------------------ | ------  | 
| id            | movie id                        | INTEGER |  
| title         | movie title                     | STRING  |   
| category      | movie category                  | STRING  |  

#### Routes

- `GET /Question3/api/movies`: This route lists all movies

- `GET //Question3/api/customer/:id`: This list information data about the user and movie rented

#### Run question 3 automation

Run file ``.feature`` 

--- 
Made with ❤️ by Thabata Almeida :computer: [Get in touch!](https://www.linkedin.com/in/thabataalmeida/)
