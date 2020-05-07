package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.validation.notnull.NotNull;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Document(indexName = "article", type = "article")
public class Article {
    @Id
    private String id;

    private String userId;

    private String title;

    private String article;

    private Timestamp timestamp;

    public Article(String id, String userId, String title, String article, Timestamp timestamp) {
        this.id = id;
        this.userId = userId;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
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
