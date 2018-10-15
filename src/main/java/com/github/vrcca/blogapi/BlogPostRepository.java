package com.github.vrcca.blogapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository // same as: @Component
public class BlogPostRepository {

    private List<BlogPost> blogPosts;

    @Autowired // optional annotation
    public BlogPostRepository(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    public List<BlogPost> findAll() {
        return Collections.unmodifiableList(blogPosts);
    }

    public BlogPost save(BlogPost newBlogPost) {
        newBlogPost = newBlogPost.withId(nextId());
        blogPosts.add(newBlogPost);
        return newBlogPost;
    }

    public Optional<BlogPost> findById(Integer id) {
        return blogPosts
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    private int nextId() {
        return blogPosts.size() + 1;
    }
}
