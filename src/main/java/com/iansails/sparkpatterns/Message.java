package com.iansails.sparkpatterns;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Provides basic app content.
 * MongoDB object constructor
 *
 * @author : ian
 * @date : 11/4/14
 */
public class Message {

    private String id;
    private String title;
    private String text;
    private Date created = new Date();

    //ideally, mongodb interop should be defined by an interface not have constructor coupling
    public Message(BasicDBObject dbObject) {
        this.id = ((ObjectId)dbObject.get("_id")).toString();
        this.title = dbObject.getString("title");
        this.text = dbObject.getString("text");
        this.created = dbObject.getDate("created");
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getCreated() {
        return created;
    }
}
