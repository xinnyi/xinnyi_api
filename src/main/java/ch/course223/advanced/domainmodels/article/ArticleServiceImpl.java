package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.config.RabbitMqService;
import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.user.User;
import ch.course223.advanced.domainmodels.user.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ArticleServiceImpl extends ExtendedServiceImpl<Article> implements ArticleService{


    private UserService userService;
    private RabbitMqService rabbitMqService;

    @Autowired
    public ArticleServiceImpl(ExtendedJpaRepository<Article> repository) {
        super(repository);
    }

    @Override
    public void addWithMessengerUserId(String messengerUserId, String url) {
        try {
            User user = userService.findByDevices(messengerUserId);
            this.addWithUserId(user.getId(), url);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Your Telegram Account is not yet linked to an Account.");
            // throw new TelegramExeception("Your Telegram Account is not yet linked to an Account.");
        }
    }

    @Override
    public void addWithUserId(String userId, String url) {
        Map<String, String> payload = new HashMap<>();
        Gson gson = new Gson();
        payload.put("userId", userId);
        rabbitMqService.publishToQueue(RabbitMqService.ARTICLE_QUEUE, gson.toJson(payload));
    }
}
