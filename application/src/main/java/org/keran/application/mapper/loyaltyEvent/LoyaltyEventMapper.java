package org.keran.application.mapper.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.infrastructure.data.LoyaltyEventApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventMapper {
    LoyaltyEventMapper INSTANCE = Mappers.getMapper(LoyaltyEventMapper.class);
    LoyaltyEventDto loyaltyEventApiObjectToDto(LoyaltyEventApiObject loyaltyEventApiObject);
    LoyaltyEventApiObject loyaltyEventDtoToApiObject(LoyaltyEventDto loyaltyEventDto);
    List<LoyaltyEventDto> loyaltyEventApiObjectListToDtoList(List<LoyaltyEventApiObject> loyaltyEventApiObjectList);
    List<LoyaltyEventApiObject> loyaltyEventDtoListToApiObjectList(List<LoyaltyEventDto> loyaltyEventDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
