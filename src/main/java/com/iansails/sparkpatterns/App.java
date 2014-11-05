package com.iansails.sparkpatterns;

import static spark.Spark.get;


/**
 * Welcome to App
 */
public class App 
{
    public static void main(String[] args) {
        get("/", (request, response) -> "Hello World");
    }

// so the lambda above (request, response) -> <result>  replaces the below java code.
//  Since get expects a route and is a single method interface, the function is coerced into a new Route
//    @Override
//    public Object handle(Request request, Response response) {
//        return "Hello World!!";
//    }
}
