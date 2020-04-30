package ch.course223.advanced.domainmodels.article;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "article", type = "article")
public class Article {
    @Id
    private String id;

    private String title;

    public Article(String id, String title) {
        this.id = id;
        this.title = title;
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
}
