package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.config.RabbitMqService;
import ch.course223.advanced.domainmodels.user.User;
import ch.course223.advanced.domainmodels.user.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private UserService userService;
    private RabbitMqService rabbitMqService;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, UserService userService, RabbitMqService rabbitMqService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
        this.rabbitMqService = rabbitMqService;
    }

    @Override
    public List<Article> getArticlesByUserId(String userId) {
        return articleRepository.findAllByUserId(userId);
    }

    @Override
    public List<Article> searchArticle(String userId, String search) {
        return articleRepository.findByArticleAndUserId(search, userId);
    }

    @Override
    public List<Article> reverseSearchArticle(String userId, String search) {
        List<Article> reversedSearch = new LinkedList<>();
        articleRepository.findAllByUserId(userId).forEach(article -> {
            if (!(article.getArticle().toLowerCase()).contains(search.toLowerCase())) {
                reversedSearch.add(article);
            }
        });
        return reversedSearch;
    }

    @Override
    public void addWithMessengerUserId(String url, Principal principal) {
        try {
            // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByEmail(principal.getName());
            this.addWithUserId(user.getId(), url);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Your Telegram Account is not yet linked to an Account.");
        }
    }

    @Override
    public void addWithUserId(String userId, String url) {
        Map<String, String> payload = new HashMap<>();
        Gson gson = new Gson();
        payload.put("userid", userId);
        payload.put("url", url);
        rabbitMqService.publishToQueue(RabbitMqService.ARTICLE_QUEUE, gson.toJson(payload));
    }
}