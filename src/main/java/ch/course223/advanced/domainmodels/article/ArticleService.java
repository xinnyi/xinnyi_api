package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedService;

import java.time.LocalDateTime;

public interface ArticleService extends ExtendedService<Article> {

    void addWithMessengerUserId(String messengerUserId, String url);
    void addWithUserId (String userId, String url);
}
