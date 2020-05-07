package ch.course223.advanced.domainmodels.dvicelinkingtoken;

import ch.course223.advanced.domainmodels.dvicelinkingtoken.mapper.DeviceLinkingTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devicelinkingtoken")
public class DeviceLinkingTokenController {

    private DeviceLinkingTokenService deviceLinkingTokenService;
    private DeviceLinkingTokenMapper deviceLinkingTokenMapper;

    @Autowired
    public DeviceLinkingTokenController(DeviceLinkingTokenService deviceRegistrationService, DeviceLinkingTokenMapper deviceRegistrationMapper) {
        this.deviceLinkingTokenService = deviceRegistrationService;
        this.deviceLinkingTokenMapper = deviceRegistrationMapper;
    }

    @PostMapping("/{id}")
    //@PreAuthorize("hasAuthority('DEVICELINKINGTOKEN_CREATE')")
    public ResponseEntity<DeviceLinkingTokenDTO> create(@PathVariable String userId) {
        return new ResponseEntity<>(deviceLinkingTokenMapper.toDTO(deviceLinkingTokenService.initialize(userId)), HttpStatus.CREATED);
    }
}
