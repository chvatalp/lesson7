package com.engeto;

import kong.unirest.JsonNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonNode commentsAsJson = new JsonDownloader().downloadFrom("https://my-json-server.typicode.com/lorant-teaching/sample-api/posts");
        List<Comment> commentList = new CommentExtractor().extractComments(commentsAsJson);

        WordCounter wordCounter = new WordCounter(commentList);
        wordCounter.print();

        System.out.println(wordCounter.count("consequatur"));
        System.out.println(wordCounter.count("voluptatem"));
    }

}
