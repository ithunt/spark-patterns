package com.iansails.sparkpatterns;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 * expose MessageService CRUD operations
 *
 * @author : ian
 * @date : 11/4/14
 */
public class MessageResource {

    private static final String API_CONTEXT = "";

    private final MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
        setupEndpoints();
    }

    private void setupEndpoints() {
        post(API_CONTEXT + "/messages", "application/json", (request, response) -> {
            messageService.createNewMessage(request.body());
            response.status(201);
            return response;
        }, new JsonTransformer());

        get(API_CONTEXT + "/messages/:id", "application/json", (request, response)
                -> messageService.find(request.params(":id")), new JsonTransformer());

        get(API_CONTEXT + "/messages", "application/json", (request, response)
                -> messageService.findAll(), new JsonTransformer());

        put(API_CONTEXT + "/messages/:id", "application/json", (request, response)
                -> messageService.update(request.params(":id"), request.body()), new JsonTransformer());
    }


}