package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class DeviceServiceImpl extends ExtendedServiceImpl<Device> implements DeviceService {

    public UserService userService;

    @Autowired
    public DeviceServiceImpl(ExtendedJpaRepository<Device> repository, UserService userService) {
        super(repository);
        this.userService = userService;
    }

    @Override
    public List<Device> findDevicesByUserId(String userId) {
        if (userService.existsById(userId)) {
            return findOrReturnNull(((DeviceRepository) repository).findDevicesByUser(userService.findById(userId)));
        } else {
            throw new NoSuchElementException("User not present");
        }
    }
}