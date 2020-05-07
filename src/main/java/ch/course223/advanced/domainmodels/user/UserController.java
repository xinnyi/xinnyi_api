package ch.course223.advanced.domainmodels.user;

import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.device.DeviceDTO;
import ch.course223.advanced.domainmodels.device.DeviceService;
import ch.course223.advanced.domainmodels.device.mapper.DeviceMapper;
import ch.course223.advanced.domainmodels.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    private DeviceService deviceService;
    private DeviceMapper deviceMapper;


    @Autowired
    public UserController(UserService userService, UserMapper userMapper, DeviceService deviceService, DeviceMapper deviceMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.deviceService = deviceService;
        this.deviceMapper = deviceMapper;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER_SEE')")
    public ResponseEntity<UserDTO> findById(@PathVariable String userId) {
        User user = userService.findById(userId);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('USER_SEE')")
    public @ResponseBody ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('USER_CREATE')")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER_MODIFY')")
    public ResponseEntity<UserDTO> updateById(@PathVariable String userId, @Valid @RequestBody UserDTO userDTO) {
        User user = userService.updateById(userId, userMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable String userId) {
        userService.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // This endpoint retrieves all devices for a single user
    @GetMapping("/{userId}/devices")
    //@PreAuthorize("hasAuthority('DEVICE_SEE')")
    public ResponseEntity<List<DeviceDTO>> getDevicesByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(deviceMapper.toDTOs(userService.findById(userId).getDevices()),HttpStatus.OK);
    }
}
