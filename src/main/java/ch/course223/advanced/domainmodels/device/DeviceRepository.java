package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends ExtendedJpaRepository<Device> {

    @Query(value = "SELECT * FROM DEVICE d WHERE d.user_id = ?1", nativeQuery = true)
    public List<Device> findDeviceByUserId(String id);
}
