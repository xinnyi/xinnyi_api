package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class DeviceServiceImpl extends ExtendedServiceImpl<Device> implements DeviceService {

    @Autowired
    public DeviceServiceImpl(ExtendedJpaRepository<Device> repository) {
        super(repository);
    }


    @Override
    public Device findByMessengerID(String messengerID) {
        return findOrThrow(((DeviceRepository)repository).findByMessengerID(messengerID));
    }

    @Override
    public List<Device> getAllDevices() {
        List<Device> deviceList = ((DeviceRepository)repository).findAll();
        return deviceList;
    }
}