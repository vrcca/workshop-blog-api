package com.github.vrcca.blogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@ComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * Creates the list of blog posts. This is a dependency of BlogPostRepository class.
     * @return An empty list of blog posts.
     */
    @Bean
    public List<BlogPost> blogPosts() {
        return new ArrayList<>();
    }
}
