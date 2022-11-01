# jb-spring-security-jwp
Spring Security with JWT

Spring Boot + Spring Security + JWT from scratch

https://www.youtube.com/watch?v=X80nJ5T7YpE&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=151

Usage:
Make a POST request to /authenticate with body:
{
   "username": "foo",
   "password": "foo"
}

It returns a jwt
Use that jwt in a GET request to /hello (In Header with Authorization value "Bearer jwt")
