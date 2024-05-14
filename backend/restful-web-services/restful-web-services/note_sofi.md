Services We Create For:[CRUD] Operation
-----------------------------------------------
1. Retrieve all Todos for A User  →  GET/users/{user_name}/todos

2. Delete a Todo of a user→ DELETE/users/{username}/todos/{id}

3. Edit/ Update a Todo→ PUT/users/{username}/todos/{id}

4. Create a new Todo→  POST/users/{username}/todos

API Testing: 
----
http://localhost:8080/users/nayaksofia/todos/1

JWT Token: 
-----
{
    "token": "eyJraWQiOiJlYjVhYzEyYi00ZDAxLTQ4OWYtYTgwNi0xZDQxODEwZWE1OTIiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiaW4yOG1pbnV0ZXMiLCJleHAiOjE3MTU2MzEyODAsImlhdCI6MTcxNTYyNTg4MCwic2NvcGUiOiJST0xFX1VTRVIifQ.Md7vE0VEUorREs9CVZkBhZu6keft7iPXihNvldci86UGPQ-8IX5RFatO6n-Ds88_GW3NIB_Q1H7QzLlDOIj2I7TKPCR2g5-4HYJ7q2KoX0kDVEXdyNtiWMpox20x7eYU7WmPFDhRdPMkGGtilbkmVooFGpFB-pH83drpOhii73Dq7pXQzcf9JMki9uz9xIe7LexfwJvS9DueDiZsiz7W4-mqaScnWZVj6xI6qPq52rUskKtsZe3unvU_4qEnPDNJYffrOtIQroRB1M5eqAP6m54HY_F2JWJmk__itDxes4xqE8AF6C9vJgTFlBewlCsdL50QH65538QC7uMuyja2sQ"
}


----
H2 console>> localhost:8080/h2-console 

---------------
insert into todo(id, username, description,target_date,is_done) values(1001,'in28minutes','Learn JPA',sysdate(),false);

insert into todo(id, username, description,target_date,is_done) values(1002,'in28minutes','Learn Data JPA',sysdate(),false);

insert into todo(id, username, description,target_date,is_done) values(1003,'in28minutes','Learn SQL',sysdate(),false);

insert into todo(id, username, description,target_date,is_done) values(1004,'in28minutes','Learn Spring Security',sysdate(),false);

insert into todo(id, username, description,target_date,is_done) values(1005,'in28minutes','Learn JWT',sysdate(),false);
