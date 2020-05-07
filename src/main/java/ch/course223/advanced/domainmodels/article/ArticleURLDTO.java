package ch.course223.advanced.domainmodels.article;

public class ArticleURLDTO {
    private String id;

    private String userId;

    public ArticleURLDTO(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public ArticleURLDTO() {
    }

    public String getId() {
        return id;
    }

    public ArticleURLDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ArticleURLDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
