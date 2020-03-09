package com.engeto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordCount;

    public WordCounter(List<Comment> commentList) {
        this.wordCount = buildWordCountMap(commentList);

    }

    private Map<String, Integer> buildWordCountMap (List<Comment> commentList) {
        wordCount = new HashMap<>();
        for (Comment element : commentList) {
            String[] pieces = element.getBody().split("\\s+");
            for (String word : pieces) {
                Integer oldCount = this.wordCount.getOrDefault(word, 0);
                this.wordCount.put(word, oldCount + 1);
            }
        }
        return wordCount;
    }

    public int count(String word) {
        return this.wordCount.get(word);
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }
}