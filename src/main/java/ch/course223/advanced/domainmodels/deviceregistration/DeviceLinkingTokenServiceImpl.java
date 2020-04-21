package ch.course223.advanced.domainmodels.deviceregistration;

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.user.UserServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceLinkingTokenServiceImpl extends ExtendedServiceImpl<DeviceLinkingToken> implements DeviceLinkingTokenService {

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
