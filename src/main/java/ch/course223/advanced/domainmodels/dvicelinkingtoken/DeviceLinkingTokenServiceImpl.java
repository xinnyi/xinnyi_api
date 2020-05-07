<<<<<<< HEAD:src/main/java/ch/course223/advanced/domainmodels/dvicelinkingtoken/DeviceLinkingTokenServiceImpl.java
package ch.course223.advanced.domainmodels.dvicelinkingtoken;
=======
package ch.course223.advanced.domainmodels.devicelinkingtoken;
>>>>>>> develop:src/main/java/ch/course223/advanced/domainmodels/devicelinkingtoken/DeviceLinkingTokenServiceImpl.java

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceLinkingTokenServiceImpl extends ExtendedServiceImpl<DeviceLinkingToken> implements DeviceLinkingTokenService {

    @Autowired
    private UserServiceImpl userService;

    public DeviceLinkingTokenServiceImpl(ExtendedJpaRepository<DeviceLinkingToken> repository) {
        super(repository);
    }

    @Override
    public DeviceLinkingToken initialize(String userId) {
        Optional<DeviceLinkingToken> deviceLinkingToken = ((DeviceLinkingTokenRepository) repository).findByUserId(userId);
        if (deviceLinkingToken.isEmpty()) {
            if (userService.existsById(userId)) {
                return save(new DeviceLinkingToken(userService.findById(userId)));
            } else {
                throw new NoSuchElementException("User not present");
            }
        } else {
            return updateById(deviceLinkingToken.get().getId(), deviceLinkingToken.get().setTokenExpirationDate(LocalDate.now().plusDays(1)));
        }
    }
}
