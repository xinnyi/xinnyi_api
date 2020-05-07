package ch.course223.advanced.domainmodels.dvicelinkingtoken.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.dvicelinkingtoken.DeviceLinkingToken;
import ch.course223.advanced.domainmodels.dvicelinkingtoken.DeviceLinkingTokenDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeviceLinkingTokenMapper extends ExtendedDTOMapper<DeviceLinkingToken, DeviceLinkingTokenDTO> {
}
