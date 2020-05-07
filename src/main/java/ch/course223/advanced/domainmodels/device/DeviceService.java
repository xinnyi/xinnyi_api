package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.core.ExtendedService;

import java.util.List;

public interface DeviceService extends ExtendedService<Device> {
    public Device findByMessengerId(String messengerId);
    public List<Device> getAllDevices();
}