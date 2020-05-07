
package ch.course223.advanced.domainmodels.devicelinkingtoken;

import ch.course223.advanced.core.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceLinkingTokenRepository extends ExtendedJpaRepository<DeviceLinkingToken> {
    Optional<DeviceLinkingToken> findByUserId(String id);
}
