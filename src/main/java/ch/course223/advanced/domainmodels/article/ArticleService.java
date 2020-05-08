package ch.course223.advanced.domainmodels.article;

import java.security.Principal;
import java.util.List;

public interface ArticleService {
    public List<Article> findAll();
    public Article save(Article article);
    public void deleteArticle(String id);
    public List<Article> searchArticle(String title);
    public List<Article> reverseSearchArticle(String title);
    public void addWithMessengerUserId(Principal principal, String url);
    public void addWithUserId(String userId, String url);

    }