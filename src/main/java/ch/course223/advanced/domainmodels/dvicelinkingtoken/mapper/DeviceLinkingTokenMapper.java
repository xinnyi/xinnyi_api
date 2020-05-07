<<<<<<< HEAD:src/main/java/ch/course223/advanced/domainmodels/dvicelinkingtoken/mapper/DeviceLinkingTokenMapper.java
package ch.course223.advanced.domainmodels.dvicelinkingtoken.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.dvicelinkingtoken.DeviceLinkingToken;
import ch.course223.advanced.domainmodels.dvicelinkingtoken.DeviceLinkingTokenDTO;
=======
package ch.course223.advanced.domainmodels.devicelinkingtoken.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.devicelinkingtoken.DeviceLinkingToken;
import ch.course223.advanced.domainmodels.devicelinkingtoken.DeviceLinkingTokenDTO;
>>>>>>> develop:src/main/java/ch/course223/advanced/domainmodels/devicelinkingtoken/mapper/DeviceLinkingTokenMapper.java
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeviceLinkingTokenMapper extends ExtendedDTOMapper<DeviceLinkingToken, DeviceLinkingTokenDTO> {
}
