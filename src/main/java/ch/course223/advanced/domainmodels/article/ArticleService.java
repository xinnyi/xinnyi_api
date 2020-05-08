package ch.course223.advanced.domainmodels.article;

import java.security.Principal;
import java.util.List;

public interface ArticleService {
    public List<Article> searchArticle(String userId, String title);
    public List<Article> reverseSearchArticle(String userId, String title);
    public void addWithMessengerUserId(String url, Principal principal);
    public void addWithUserId(String userId, String url);
    public List<Article> getArticlesByUserId(String userId);

    }