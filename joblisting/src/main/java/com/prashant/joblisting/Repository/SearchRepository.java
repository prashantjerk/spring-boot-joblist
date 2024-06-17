package com.prashant.joblisting.Repository;

import com.prashant.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
