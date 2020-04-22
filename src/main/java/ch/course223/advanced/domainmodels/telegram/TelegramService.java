package ch.course223.advanced.domainmodels.telegram;

public interface TelegramService {
    public void linkDeviceToUser (String telegramUserId,  String deviceLinkingToken);
}
