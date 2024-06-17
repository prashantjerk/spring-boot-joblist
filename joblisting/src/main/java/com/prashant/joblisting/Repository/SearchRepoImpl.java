package com.prashant.joblisting.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prashant.joblisting.model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        List<Post> posts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("jobsite");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text).append("path", Arrays.asList("tech_stacks", "description", "position")))),
                        new Document("$sort",
                        new Document("experience_years", 1L)),
                        new Document("$limit", 5L)));

        // iterate through the result and add it to the list
        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));

        return posts;
    }
}
