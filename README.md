#Simple Message App Using Spark and AngularJS

	bower install
	mvn package
	java -jar target/spark-patterns-1.0-SNAPSHOT.jar
	http://localhost:8080

Spark makes it simple to build a lightweight java web application. Packaging it into a jar is kinda cool but it's missing the simplicity of Spring MVC for certain
Java 8 Syntax is sorta better than @Annotations Though its honestly isn't as readable

     post(API_CONTEXT + "/messages", "application/json", (request, response) -> {
                messageService.createNewMessage(request.body());
                response.status(201);
                return response;
            }, new JsonTransformer());

     get(API_CONTEXT + "/messages/:id", "application/json", (request, response)
                    -> messageService.find(request.params(":id")), new JsonTransformer());

Learned alot about how to setup bower which I will definitely use in future apps.

    bower install jquery --save

### Articles
https://blog.openshift.com/developing-single-page-web-applications-using-java-8-spark-mongodb-and-angularjs/
https://thinkster.io/egghead/intro-to-bower/

### Status
the app is broken due to infinite Gson loop in a resolve. Debugging is terrible. Spark may not be for me
