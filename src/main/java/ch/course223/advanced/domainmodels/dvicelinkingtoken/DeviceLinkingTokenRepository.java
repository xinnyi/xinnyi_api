<<<<<<< HEAD:src/main/java/ch/course223/advanced/domainmodels/dvicelinkingtoken/DeviceLinkingTokenRepository.java
package ch.course223.advanced.domainmodels.dvicelinkingtoken;
=======
package ch.course223.advanced.domainmodels.devicelinkingtoken;
>>>>>>> develop:src/main/java/ch/course223/advanced/domainmodels/devicelinkingtoken/DeviceLinkingTokenRepository.java

import ch.course223.advanced.core.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceLinkingTokenRepository extends ExtendedJpaRepository<DeviceLinkingToken> {
    Optional<DeviceLinkingToken> findByUserId(String id);
}
