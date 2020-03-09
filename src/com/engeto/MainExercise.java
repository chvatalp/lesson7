package com.engeto;

import kong.unirest.JsonNode;

import java.util.List;

public class MainExercise {
    public static void main(String[] args) {
        JsonNode commentsAsJson = new JsonDownloader().downloadFrom("https://my-json-server.typicode.com/lorant-teaching/sample-api/posts");
        List<Comment> commentList = new CommentExtractor().extractComments(commentsAsJson);

        idCounter idCounter = new idCounter(commentList);
        for (String key : idCounter.getIdCount().keySet()) {
            System.out.println(key + " : " + idCounter.count(key).toString());

        }
    }

}
