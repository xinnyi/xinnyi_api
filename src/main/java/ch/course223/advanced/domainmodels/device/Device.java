package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedEntity;
import ch.course223.advanced.domainmodels.user.User;

import javax.persistence.*;

@Entity
@Table (name = "device")
public class Device extends ExtendedEntity {

    @Column (name = "telegram_id")
    private String telegramID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Device() {}

    public String getTelegramID() {
        return telegramID;
    }

    public Device setTelegramID(String telegramID) {
        this.telegramID = telegramID;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Device setUser(User user) {
        this.user = user;
        return this;
    }
}
