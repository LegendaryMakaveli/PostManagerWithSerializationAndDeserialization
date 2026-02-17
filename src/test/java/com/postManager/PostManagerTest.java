package com.postManager;

import com.postManagerApp.Post;
import com.postManagerApp.PostManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostManagerTest {

    @Test
    void testCanSerializePost() {
        Post post = new Post();
        post.setId(1);
        post.setPostId(1000);
        post.setEmail("Makaveli@email.com");
        post.setBody("This is a test post");
        post.setAuthor("Makaveli");
        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.of(12,00));
        post.setDate(date);

        String json = PostManager.serialize(post);
        assertNotNull(json);
        String expected = generateToken();
        assertEquals(expected, json);
    }

    @Test
    void testCanWritePostToFile() {
        Post post = new Post();
        post.setId(1);
        post.setPostId(1000);
        post.setEmail("Makaveli@gmail.com");
        post.setBody("This is a test post");
        post.setAuthor("Makaveli");

        String fileName = "data.json";
        Path filePath = Paths.get(fileName);

        try {
            PostManager.writeJsonToFile(post, fileName);

            assert (Files.exists(filePath));
            String content = Files.readString(filePath);
            assertNotNull(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testCanDeserialize(){
        String json = generateToken();
        Post post = PostManager.deserialize(json);
        assertNotNull(post);
        assertEquals(1, post.getId());
        assertEquals(1000, post.getPostId());
        assertEquals("Makaveli@email.com", post.getEmail());
        assertEquals("This is a test post", post.getBody());
        assertEquals("Makaveli", post.getAuthor());

    }

    @Test
    void testCanSerializePostWithDate() {
        Post post = new Post();
        post.setId(1);
        post.setPostId(1000);
        post.setEmail("Makaveli@email.com");
        post.setBody("This is a test post");
        post.setAuthor("Makaveli");
        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.of(12,00));
        post.setDate(date);
        String json = PostManager.serialize(post);
        System.out.println("Json :" + json);
        assertNotNull(json);
        String expected = generateToken();
        assertEquals(expected, json);
    }



    private static String generateToken() {
        String json = """
              {
                "id" : 1,
                "postId" : 1000,
                "email" : "Makaveli@email.com",
                "body" : "This is a test post",
                "author" : "Makaveli",
                "date" : [ 2026, 2, 17, 12, 0 ]
              }""";

        return json;
    }
}
