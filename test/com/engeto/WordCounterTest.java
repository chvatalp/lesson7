package com.engeto;import kong.unirest.JsonNode;
import org.junit.Assert;
import org.junit.Test;import java.util.List;public class WordCounterTest
{
    @Test
    public void countTest() {
        JsonNode commentsAsJson = new JsonDownloader().downloadFrom("https://my-json-server.typicode.com/lorant-teaching/sample-api/posts");
        List<Comment> commentList = new CommentExtractor().extractComments(commentsAsJson);
        WordCounter counter = new WordCounter(commentList);
        Assert.assertEquals(3, counter.count("consequatur"));
        Assert.assertEquals(10, counter.count("voluptatem"));
    }
}
