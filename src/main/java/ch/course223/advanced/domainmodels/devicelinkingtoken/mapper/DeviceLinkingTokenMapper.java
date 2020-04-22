package ch.course223.advanced.domainmodels.devicelinkingtoken.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.devicelinkingtoken.DeviceLinkingToken;
import ch.course223.advanced.domainmodels.devicelinkingtoken.DeviceLinkingTokenDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeviceLinkingTokenMapper extends ExtendedDTOMapper<DeviceLinkingToken, DeviceLinkingTokenDTO> {
}
