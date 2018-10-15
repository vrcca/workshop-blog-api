package com.github.vrcca.blogapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin // This is required so the ReactJS app can call it from a different origin.
public class PostsController {

    private final BlogPostRepository repository;

    @Autowired // optional annotation
    public PostsController(BlogPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping // same as: @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BlogPost>> listPosts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost newBlogPost) {
        newBlogPost = repository.save(newBlogPost);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newBlogPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> findPostById(@PathVariable("id") Integer id) {
        Optional<BlogPost> maybeBlogPost = repository.findById(id);
        if (!maybeBlogPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(maybeBlogPost.get());
    }
}
