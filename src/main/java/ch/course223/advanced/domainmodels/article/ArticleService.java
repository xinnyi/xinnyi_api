package ch.course223.advanced.domainmodels.article;

import java.util.List;

public interface ArticleService {
    public Article save(Article article);
    public List<Article> findByTitle(String title);
}
