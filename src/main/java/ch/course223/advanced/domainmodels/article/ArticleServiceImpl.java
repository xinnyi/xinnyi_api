package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.config.RabbitMqService;
import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.user.User;
import ch.course223.advanced.domainmodels.user.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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
    public void addWithTelegramUserId(String telegramUserId, String url, LocalDateTime timestamp) {
        try {
            User user = userService.findByDevices(telegramUserId);
            this.addWithUserId(user.getId(), url, timestamp);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Your Telegram Account is not yet linked to an Account.");
            // throw new TelegramExeception("Your Telegram Account is not yet linked to an Account.");
        }
    }

    @Override
    public void addWithUserId(String userId, String url, LocalDateTime timestamp) {
        Map<String, String> payload = new HashMap<>();
        Gson gson = new Gson();
        payload.put("userId", userId);
        payload.put("timestamp", timestamp.atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        rabbitMqService.publishToQueue(RabbitMqService.ARTICLE_QUEUE, gson.toJson(payload));
    }
}
