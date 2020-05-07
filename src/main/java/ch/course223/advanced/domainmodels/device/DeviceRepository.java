package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.domainmodels.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends ExtendedJpaRepository<Device> {

}
