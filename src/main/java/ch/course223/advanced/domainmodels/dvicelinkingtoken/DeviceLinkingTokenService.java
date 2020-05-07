<<<<<<< HEAD:src/main/java/ch/course223/advanced/domainmodels/dvicelinkingtoken/DeviceLinkingTokenService.java
package ch.course223.advanced.domainmodels.dvicelinkingtoken;
=======
package ch.course223.advanced.domainmodels.devicelinkingtoken;
>>>>>>> develop:src/main/java/ch/course223/advanced/domainmodels/devicelinkingtoken/DeviceLinkingTokenService.java

import ch.course223.advanced.core.ExtendedService;

public interface DeviceLinkingTokenService extends ExtendedService<DeviceLinkingToken> {
    public DeviceLinkingToken initialize(String userId);
}
