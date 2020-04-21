package ch.course223.advanced.domainmodels.device.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.device.DeviceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface DeviceMapper extends ExtendedDTOMapper<Device, DeviceDTO> {
}
