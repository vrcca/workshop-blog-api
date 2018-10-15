package com.github.vrcca.blogapi;

public class BlogPost {

    private final Integer id;
    private final String title;
    private final String description;

    public BlogPost(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BlogPost withId(int id) {
        return new BlogPost(id, this.title, this.description);
    }
}
