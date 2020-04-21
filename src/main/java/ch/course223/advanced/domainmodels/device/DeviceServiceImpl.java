package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceServiceImpl extends ExtendedServiceImpl<Device> implements DeviceService {

    public DeviceRepository deviceRepository;

    public DeviceServiceImpl (ExtendedJpaRepository<Device> repository, DeviceRepository deviceRepository) {
        super(repository);
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> findDeviceByUserId(String id) {
        return deviceRepository.findDeviceByUserId(id);
    }
}
