package com.prashant.joblisting.controller;

import javax.servlet.http.HttpServletResponse;

import com.prashant.joblisting.Repository.PostRepository;
import com.prashant.joblisting.Repository.SearchRepository;
import com.prashant.joblisting.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {



    @Autowired
    PostRepository repo;    // this means an instance of PostRepo is created by the Spring itself

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/");
    }


    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }
}
