<<<<<<< HEAD:src/main/java/ch/course223/advanced/domainmodels/dvicelinkingtoken/DeviceLinkingTokenDTO.java
package ch.course223.advanced.domainmodels.dvicelinkingtoken;
=======
package ch.course223.advanced.domainmodels.devicelinkingtoken;
>>>>>>> develop:src/main/java/ch/course223/advanced/domainmodels/devicelinkingtoken/DeviceLinkingTokenDTO.java

import ch.course223.advanced.core.ExtendedDTO;
import ch.course223.advanced.domainmodels.user.User;

import java.time.LocalDate;

public class DeviceLinkingTokenDTO extends ExtendedDTO {
    private String token;

    private LocalDate tokenExpirationDate;

    private User user;

    public String getToken() {
        return token;
    }

    public DeviceLinkingTokenDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public LocalDate getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public DeviceLinkingTokenDTO setTokenExpirationDate(LocalDate tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public DeviceLinkingTokenDTO setUser(User user) {
        this.user = user;
        return this;
    }
}
