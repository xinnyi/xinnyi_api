
package ch.course223.advanced.domainmodels.devicelinkingtoken;

import ch.course223.advanced.core.ExtendedEntity;
import ch.course223.advanced.domainmodels.user.User;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "device_linking_token")
public class DeviceLinkingToken extends ExtendedEntity {

    @Column(name = "token")
    private String token;

    @Column(name = "token_expiration_date")
    private LocalDate tokenExpirationDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public DeviceLinkingToken(User user) {
        this.user = user;
        this.tokenExpirationDate = LocalDate.now().plusDays(1);
        this.token = UUID.randomUUID().toString();
    }

    public DeviceLinkingToken() {
    }

    public String getToken() {
        return token;
    }

    public DeviceLinkingToken setToken(String token) {
        this.token = token;
        return this;
    }

    public LocalDate getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public DeviceLinkingToken setTokenExpirationDate(LocalDate tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public DeviceLinkingToken setUser(User user) {
        this.user = user;
        return this;
    }
}
