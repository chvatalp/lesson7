package com.engeto;

import kong.unirest.JsonNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{

    public static void main(String[] args)
    {
        JsonNode commentsAsJson = new JsonDownloader().downloadFrom("https://jsonplaceholder.typicode.com/comments");
        List<Comment> commentList = new CommentExtractor().extractComments(commentsAsJson);

        Map<String, Integer> wordCount = new HashMap<>();
        for (Comment element : commentList) {
            String[] pieces = element.getBody().split("\\s+");
            for (String word : pieces) {
                Integer oldCount = wordCount.getOrDefault(word, 0);
                wordCount.put(word, oldCount + 1);
            }
        }
        for (String key : wordCount.keySet()) {
            System.out.println(key + " : " + wordCount.get(key));
        }

        System.out.println(wordCount.get("enim"));
    }

}
