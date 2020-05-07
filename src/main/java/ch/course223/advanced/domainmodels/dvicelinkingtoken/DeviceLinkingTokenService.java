package ch.course223.advanced.domainmodels.dvicelinkingtoken;

import ch.course223.advanced.core.ExtendedService;

public interface DeviceLinkingTokenService extends ExtendedService<DeviceLinkingToken> {
    public DeviceLinkingToken initialize(String userId);
}
