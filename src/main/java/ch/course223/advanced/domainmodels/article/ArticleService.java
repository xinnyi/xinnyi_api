package ch.course223.advanced.domainmodels.article;

import java.util.List;

public interface ArticleService {
    public List<Article> findAll();
    public Article save(Article article);
    public void deleteArticle(String id);
    public List<Article> findByTitle(String title);
    public List<Article> reverseSearchTitle(String title);
}
