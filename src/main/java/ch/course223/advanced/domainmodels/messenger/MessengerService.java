package ch.course223.advanced.domainmodels.messenger;

import java.time.LocalDateTime;

public interface MessengerService {

    public void linkDeviceToUser (String messengerUserId,  String deviceLinkingToken);
    // void addWithMessengerUserId(String messengerUserId, String url, LocalDateTime timestamp);
    // void addWithUserId (String userId, String url, LocalDateTime timestamp);
}
