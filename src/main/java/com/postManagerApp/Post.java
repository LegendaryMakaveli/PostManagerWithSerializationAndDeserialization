package com.postManagerApp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;

public class Post {
    private int id;
    private int postId;
    private String email;
    private String body;
    private String author;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;

    public Post() {
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthor() {
        return author;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}

