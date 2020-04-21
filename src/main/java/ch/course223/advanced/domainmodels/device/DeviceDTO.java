package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedDTO;
import ch.course223.advanced.domainmodels.user.User;

import java.time.LocalDate;

public class DeviceDTO extends ExtendedDTO {

    private String telegramID;

    private LocalDate createdAt;

    public DeviceDTO() {}

    public String getTelegramID() {
        return telegramID;
    }

    public DeviceDTO setTelegramID(String telegramID) {
        this.telegramID = telegramID;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public DeviceDTO setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
