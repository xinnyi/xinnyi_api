package ch.course223.advanced.domainmodels.telegram;

import ch.course223.advanced.domainmodels.device.DeviceService;
import ch.course223.advanced.domainmodels.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telegram")
public class TelegramController {

    private TelegramServiceImpl telegramServiceImpl;

    @Autowired
    public TelegramController(TelegramServiceImpl telegramServiceImpl) {
        this.telegramServiceImpl = telegramServiceImpl;
    }

    @PostMapping({"/{telegramUserId}/{deviceLinkingToken}", "/{telegramUserId}/{deviceLinkingToken}/"})
    public ResponseEntity<Void> linkDeviceToUser(@PathVariable String telegramUserId, @PathVariable String deviceLinkingToken) {
        telegramServiceImpl.linkDeviceToUser(telegramUserId, deviceLinkingToken);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
