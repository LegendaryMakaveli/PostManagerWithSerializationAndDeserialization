package com.postManagerApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class PostManager {
    public static ObjectMapper mapper = new ObjectMapper();
    public static String serialize(Post post){
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try{
            String json = mapper.writeValueAsString(post);
            return json;
        }catch (JsonProcessingException ex){
            throw new RuntimeException(ex);
        }
    }

    public static void writeJsonToFile(Post post, String fileName){
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), post);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Post deserialize(String json) {
        try {
            return mapper.readValue(json, Post.class);
        }catch (JsonProcessingException ex){
            throw new RuntimeException(ex);
        }

    }
}