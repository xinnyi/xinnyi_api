package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedService;

import java.security.Principal;
import java.time.LocalDateTime;

public interface ArticleService extends ExtendedService<Article> {

    //void addWithMessengerUserId(String messengerUserId, String url);
    void addWithMessengerUserId(Principal principal, String url);
    void addWithUserId (String userId, String url);
}
