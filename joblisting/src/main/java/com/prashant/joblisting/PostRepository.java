package com.prashant.joblisting;

import com.prashant.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post, String> {
//        MongoDBRepository<Post, String>
//        here Post is used because this repo manages the Post type of object
//        String is used to give an id to the object
}
