package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedEntity;
import ch.course223.advanced.domainmodels.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "device")
public class Device extends ExtendedEntity {

    @Column (name = "messenger_id")
    private String messengerId;

    @Column (name = "created_at")
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    public Device() {}

    public Device(String messengerID, LocalDate createdAt) {
        this.messengerId = messengerID;
        this.createdAt = LocalDate.now();
    }

    public Device(String messengerID, LocalDate createdAt, User user) {
        this.messengerId = messengerID;
        this.createdAt = createdAt;
        this.user = user;
    }

    public String getMessengerID() {
        return messengerId;
    }

    public Device setMessengerID(String telegramID) {
        this.messengerId = telegramID;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Device setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
