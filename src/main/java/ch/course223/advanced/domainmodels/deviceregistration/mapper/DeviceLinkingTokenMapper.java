package ch.course223.advanced.domainmodels.deviceregistration.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.deviceregistration.DeviceLinkingToken;
import ch.course223.advanced.domainmodels.deviceregistration.DeviceLinkingTokenDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeviceLinkingTokenMapper extends ExtendedDTOMapper<DeviceLinkingToken, DeviceLinkingTokenDTO> {
}
