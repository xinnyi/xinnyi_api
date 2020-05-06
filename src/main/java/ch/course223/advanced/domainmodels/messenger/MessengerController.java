package ch.course223.advanced.domainmodels.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messenger")
public class MessengerController {

    private MessengerServiceImpl messengerServiceImpl;

    @Autowired
    public MessengerController(MessengerServiceImpl messengerServiceImpl) {
        this.messengerServiceImpl = messengerServiceImpl;
    }

    @PostMapping({"/{messengerUserId}/{deviceLinkingToken}", "/{messengerUserId}/{deviceLinkingToken}/"})
    public ResponseEntity<Void> linkDeviceToUser(@PathVariable String messengerUserId, @PathVariable String deviceLinkingToken) {
        messengerServiceImpl.linkDeviceToUser(messengerUserId, deviceLinkingToken);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
