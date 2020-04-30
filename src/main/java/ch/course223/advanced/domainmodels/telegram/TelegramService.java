package ch.course223.advanced.domainmodels.telegram;

import java.time.LocalDateTime;

public interface TelegramService {

    public void linkDeviceToUser (String telegramUserId,  String deviceLinkingToken);
    void addWithTelegramUserId(String telegramUserId, String url, LocalDateTime timestamp);
    void addWithUserId (String userId, String url, LocalDateTime timestamp);
}
