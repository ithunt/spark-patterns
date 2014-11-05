package com.iansails.sparkpatterns;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * spark-patterns
 *
 * @author : ian
 * @date : 11/4/14
 */
public class MessageService {

    //message: use a DI injection system. Dagger or Guice

    private final DB db;
    private final DBCollection collection;

    public MessageService(DB db) {
        this.db = db;
        this.collection = db.getCollection("message");
    }

    public List<Message> findAll() {
        final List<Message> message = new ArrayList<>();
        DBCursor dbObjects = collection.find();
        while ( dbObjects.hasNext() ) {
            DBObject dbObject = dbObjects.next();
            message.add(new Message((BasicDBObject)dbObject)); //not liking this typecasting
        }
        return message;
    }

    public void createNewMessage(String body) {
        Message message = new Gson().fromJson(body, Message.class);
        collection.insert(new BasicDBObject("title", message.getTitle()).append("text", message.getText()));
    }

    public Message find(String id) {
        return new Message((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
    }

    public Message update(String messageId, String body) {
        Message message = new Gson().fromJson(body, Message.class);
        collection.update(new BasicDBObject("_id", new ObjectId(messageId)),
                new BasicDBObject("$set",
                        new BasicDBObject("text",
                        message.getText()))
                        .append("$set",
                                new BasicDBObject("title", message.getText())));
        return this.find(messageId);
    }

}
