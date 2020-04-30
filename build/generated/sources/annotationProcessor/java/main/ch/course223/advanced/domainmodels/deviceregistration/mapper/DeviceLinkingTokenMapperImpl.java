package ch.course223.advanced.domainmodels.deviceregistration.mapper;

import ch.course223.advanced.domainmodels.deviceregistration.DeviceLinkingToken;
import ch.course223.advanced.domainmodels.deviceregistration.DeviceLinkingTokenDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2020-04-29T14:09:48+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
=======
    date = "2020-04-29T13:53:55+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
>>>>>>> 069939e57a340439766008e4f2b91ffe2d83ba47
)
@Component
public class DeviceLinkingTokenMapperImpl implements DeviceLinkingTokenMapper {

    @Override
    public DeviceLinkingToken fromDTO(DeviceLinkingTokenDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DeviceLinkingToken deviceLinkingToken = new DeviceLinkingToken();

        deviceLinkingToken.setId( dto.getId() );
        deviceLinkingToken.setToken( dto.getToken() );
        deviceLinkingToken.setTokenExpirationDate( dto.getTokenExpirationDate() );
        deviceLinkingToken.setUser( dto.getUser() );

        return deviceLinkingToken;
    }

    @Override
    public List<DeviceLinkingToken> fromDTOs(List<DeviceLinkingTokenDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<DeviceLinkingToken> list = new ArrayList<DeviceLinkingToken>( dtos.size() );
        for ( DeviceLinkingTokenDTO deviceLinkingTokenDTO : dtos ) {
            list.add( fromDTO( deviceLinkingTokenDTO ) );
        }

        return list;
    }

    @Override
    public Set<DeviceLinkingToken> fromDTOs(Set<DeviceLinkingTokenDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<DeviceLinkingToken> set = new HashSet<DeviceLinkingToken>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( DeviceLinkingTokenDTO deviceLinkingTokenDTO : dtos ) {
            set.add( fromDTO( deviceLinkingTokenDTO ) );
        }

        return set;
    }

    @Override
    public DeviceLinkingTokenDTO toDTO(DeviceLinkingToken dm) {
        if ( dm == null ) {
            return null;
        }

        DeviceLinkingTokenDTO deviceLinkingTokenDTO = new DeviceLinkingTokenDTO();

        deviceLinkingTokenDTO.setId( dm.getId() );
        deviceLinkingTokenDTO.setToken( dm.getToken() );
        deviceLinkingTokenDTO.setTokenExpirationDate( dm.getTokenExpirationDate() );
        deviceLinkingTokenDTO.setUser( dm.getUser() );

        return deviceLinkingTokenDTO;
    }

    @Override
    public List<DeviceLinkingTokenDTO> toDTOs(List<DeviceLinkingToken> dms) {
        if ( dms == null ) {
            return null;
        }

        List<DeviceLinkingTokenDTO> list = new ArrayList<DeviceLinkingTokenDTO>( dms.size() );
        for ( DeviceLinkingToken deviceLinkingToken : dms ) {
            list.add( toDTO( deviceLinkingToken ) );
        }

        return list;
    }

    @Override
    public Set<DeviceLinkingTokenDTO> toDTOs(Set<DeviceLinkingToken> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<DeviceLinkingTokenDTO> set = new HashSet<DeviceLinkingTokenDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( DeviceLinkingToken deviceLinkingToken : dms ) {
            set.add( toDTO( deviceLinkingToken ) );
        }

        return set;
    }
}
