package com.engeto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordCount;

    public WordCounter(List<Comment> commentList) {
        this.wordCount = new HashMap<>();
        for (Comment element : commentList) {
            String[] pieces = element.getBody().split("\\s+");
            for (String word : pieces) {
                Integer oldCount = this.wordCount.getOrDefault(word, 0);
                this.wordCount.put(word, oldCount + 1);
            }
        }
    }

    public int count(String word) {
        return this.wordCount.get(word);
    }

    public void print() {
        for (String key : this.wordCount.keySet()) {
            System.out.println(key + " : " + this.wordCount.get(key));
        }
    }
}