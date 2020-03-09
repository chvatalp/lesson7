package com.engeto;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class idCounter {
    private Map<String, HashSet<Integer>> idCount;

    public idCounter(List<Comment> idList) {
        this.idCount = buildIdCountMap(idList);

    }

    private Map<String, HashSet<Integer>> buildIdCountMap (List<Comment> idList) {
        HashMap<String, HashSet<Integer>> idCount = new HashMap<>();
        for (Comment element : idList) {
            Integer id = element.getId();
            String[] pieces = element.getBody().split("\\s+");
            for (String word : pieces) {
                if (idCount.get(word) == null) {
                    HashSet<Integer> buffer = new HashSet<>();
                    buffer.add(id);
                    idCount.put(word, buffer);
                } else {
                    HashSet<Integer> buffer = idCount.get(word);
                    buffer.add(id);
                }
            }
        }
        return idCount;
    }

    public HashSet<Integer> count(String word) {
        return this.idCount.get(word);
    }

    public Map<String, HashSet<Integer>> getIdCount() {
        return this.idCount;
    }
}

