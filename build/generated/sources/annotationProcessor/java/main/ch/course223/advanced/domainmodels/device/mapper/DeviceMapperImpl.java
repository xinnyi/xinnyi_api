package ch.course223.advanced.domainmodels.device.mapper;

import ch.course223.advanced.domainmodels.device.Device;
import ch.course223.advanced.domainmodels.device.DeviceDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-08T15:37:51+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public Device fromDTO(DeviceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Device device = new Device();

        device.setId( dto.getId() );
        device.setCreatedAt( dto.getCreatedAt() );

        return device;
    }

    @Override
    public List<Device> fromDTOs(List<DeviceDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Device> list = new ArrayList<Device>( dtos.size() );
        for ( DeviceDTO deviceDTO : dtos ) {
            list.add( fromDTO( deviceDTO ) );
        }

        return list;
    }

    @Override
    public Set<Device> fromDTOs(Set<DeviceDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Device> set = new HashSet<Device>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( DeviceDTO deviceDTO : dtos ) {
            set.add( fromDTO( deviceDTO ) );
        }

        return set;
    }

    @Override
    public DeviceDTO toDTO(Device dm) {
        if ( dm == null ) {
            return null;
        }

        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setId( dm.getId() );
        deviceDTO.setCreatedAt( dm.getCreatedAt() );

        return deviceDTO;
    }

    @Override
    public List<DeviceDTO> toDTOs(List<Device> dms) {
        if ( dms == null ) {
            return null;
        }

        List<DeviceDTO> list = new ArrayList<DeviceDTO>( dms.size() );
        for ( Device device : dms ) {
            list.add( toDTO( device ) );
        }

        return list;
    }

    @Override
    public Set<DeviceDTO> toDTOs(Set<Device> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<DeviceDTO> set = new HashSet<DeviceDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( Device device : dms ) {
            set.add( toDTO( device ) );
        }

        return set;
    }
}
