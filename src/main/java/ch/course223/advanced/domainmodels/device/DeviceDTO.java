package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedDTO;
import ch.course223.advanced.domainmodels.user.User;

public class DeviceDTO extends ExtendedDTO {

    private String telegramID;

    private User user;

    public DeviceDTO() {}

    public String getTelegramID() {
        return telegramID;
    }

    public DeviceDTO setTelegramID(String telegramID) {
        this.telegramID = telegramID;
        return this;
    }

    public User getUser() {
        return user;
    }

    public DeviceDTO setUser(User user) {
        this.user = user;
        return this;
    }
}
