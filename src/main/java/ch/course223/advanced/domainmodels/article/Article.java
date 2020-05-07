package ch.course223.advanced.domainmodels.article;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.sql.Timestamp;

@Document(indexName = "article", type = "article")
public class Article {
    @Id
    private String id;

    private String userId;

    private String article;

    private Timestamp timestamp;

    public Article(String id, String userId, String article, Timestamp timestamp) {
        this.id = id;
        this.userId = userId;
        this.article = article;
        this.timestamp = timestamp;
    }

    public Article() {
    }

    public String getId() {
        return id;
    }

    public Article setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Article setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getArticle() {
        return article;
    }

    public Article setArticle(String article) {
        this.article = article;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Article setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}