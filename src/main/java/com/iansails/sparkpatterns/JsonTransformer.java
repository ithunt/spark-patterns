package com.iansails.sparkpatterns;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * spark-patterns
 *
 * @author : ian
 * @date : 11/4/14
 */
public class JsonTransformer implements ResponseTransformer {

//    private Gson gson = ;

    @Override
    public String render(Object model) throws Exception {
        return new Gson().toJson(model);
    }
}
