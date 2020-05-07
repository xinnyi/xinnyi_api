package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.validation.notnull.NotNull;

import java.sql.Timestamp;

public class ArticleDTO {
    private String id;

    private String userId;

    private String article;

    private Timestamp timestamp;

    public ArticleDTO(String id, String userId, String article, Timestamp timestamp) {
        this.id = id;
        this.userId = userId;
        this.article = article;
        this.timestamp = timestamp;
    }

    public ArticleDTO() {
    }

    public String getId() {
        return id;
    }

    public ArticleDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ArticleDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getArticle() {
        return article;
    }

    public ArticleDTO setArticle(String article) {
        this.article = article;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public ArticleDTO setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
