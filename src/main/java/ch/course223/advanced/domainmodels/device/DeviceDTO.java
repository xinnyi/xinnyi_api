package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedDTO;
import ch.course223.advanced.domainmodels.user.User;

import java.time.LocalDate;

public class DeviceDTO extends ExtendedDTO {

    private String messengerId;

    private LocalDate createdAt;

    private User user;

    public DeviceDTO() {}

    public String getMessengerId() {
        return messengerId;
    }

    public DeviceDTO setMessengerId(String messengerId) {
        this.messengerId = messengerId;
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

