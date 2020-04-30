package ch.course223.advanced.domainmodels.telegram;

import ch.course223.advanced.config.RabbitMqService;
import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.devicelinkingtoken.DeviceLinkingTokenService;
import ch.course223.advanced.domainmodels.user.User;
import ch.course223.advanced.domainmodels.user.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class TelegramServiceImpl implements TelegramService {

    private DeviceLinkingTokenService deviceLinkingTokenService;

    private UserService userService;
    private RabbitMqService rabbitMqService;

    @Autowired
    public TelegramServiceImpl(DeviceLinkingTokenService deviceLinkingTokenService, UserService userService) {
        this.deviceLinkingTokenService = deviceLinkingTokenService;
        this.userService = userService;
    }

    @Override
    public void linkDeviceToUser(String telegramUserId, String deviceLinkingToken) {
        if (deviceLinkingTokenService.existsById(deviceLinkingToken)) {
            User userToLink = deviceLinkingTokenService.findById(deviceLinkingToken).getUser();
            List<Device> currentDevices = userToLink.getDevices();
            currentDevices.add(new Device(telegramUserId, LocalDate.now()));
            userToLink.setDevices(currentDevices);
            userService.updateById(userToLink.getId(), userToLink);
        } else {
            throw new NoSuchElementException("Token not present");
        }
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
