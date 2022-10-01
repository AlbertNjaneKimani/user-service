# user-service
## Description:
 This is a user Microservice where a user can top up account balance, 
and do transactions. This Service will iunteract with order microservice where the orders for a speciffic user 
will be monotored.
## Technologies Used
1. Java
2. Spring Boot Reactive
3. MySQL
4. GIT
## It has the following end points

```
1.GET all users: http://localhost:8092/user/all

2.GET single User: http://localhost:8092/user/{id}

3.POST user: http://localhost:8092/user

4.PUT(Update) user: http://localhost:8092/user/{id}

5.DELETE user: http://localhost:8092/user/{id}
```

