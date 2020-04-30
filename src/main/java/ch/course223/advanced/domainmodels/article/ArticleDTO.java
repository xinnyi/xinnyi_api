package ch.course223.advanced.domainmodels.article;

public class ArticleDTO {
    private String id;

    private String title;

    public ArticleDTO(String id, String title) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public ArticleDTO setTitle(String title) {
        this.title = title;
        return this;
    }
}
