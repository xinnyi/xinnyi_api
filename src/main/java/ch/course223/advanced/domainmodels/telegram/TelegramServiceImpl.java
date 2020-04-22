package ch.course223.advanced.domainmodels.telegram;

import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.devicelinkingtoken.DeviceLinkingTokenService;
import ch.course223.advanced.domainmodels.user.User;
import ch.course223.advanced.domainmodels.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TelegramServiceImpl implements TelegramService {

    private DeviceLinkingTokenService deviceLinkingTokenService;

    private UserService userService;

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
}
