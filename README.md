# Java EE Restful webservice with JPA and AngularJS

This simple example shows how make a CRUD with Angular and a Java EE Restful webservice.

![](http://i.imgur.com/FYuHxI1.png)

### How to run

1. Create a database for your DataSource.
2. Create a new DataSource in your server (i've use WildFly 9.1)
3. Modify the **persistence.xml** file and change the DataSource name: `<jta-data-source>your datasource jndi name here</jta-data-source>`.
4. Compile and run.
