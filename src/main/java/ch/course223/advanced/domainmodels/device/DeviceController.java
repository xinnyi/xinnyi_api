package ch.course223.advanced.domainmodels.device;

import ch.course223.advanced.domainmodels.device.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/devices")
public class DeviceController {

    private DeviceService deviceService;

    private DeviceMapper deviceMapper;

    @Autowired
    public DeviceController (DeviceService deviceService, DeviceMapper deviceMapper) {
        this.deviceService = deviceService;
        this.deviceMapper = deviceMapper;
    }

    // This endpoint retrieves all devices for a single user
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_SEE')")
    public ResponseEntity<List<DeviceDTO>> getDevicesByUserId(@PathVariable String id) {
        return new ResponseEntity<>(deviceMapper.toDTOs(deviceService.findDeviceByUserId(id)));
    }
}
