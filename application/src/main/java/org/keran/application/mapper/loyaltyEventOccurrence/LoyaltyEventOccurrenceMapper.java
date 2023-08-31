package org.keran.application.mapper.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventOccurrenceMapper {
    LoyaltyEventOccurrenceMapper INSTANCE = Mappers.getMapper(LoyaltyEventOccurrenceMapper.class);
    LoyaltyEventOccurrenceDto loyaltyEventOccurrenceApiObjectToDto(LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject);
    LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceDtoToApiObject(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
    List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceApiObjectListToDtoList(List<LoyaltyEventOccurrenceApiObject> loyaltyEventOccurrenceApiObjectList);
    List<LoyaltyEventOccurrenceApiObject> loyaltyEventOccurrenceDtoListToApiObjectList(List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
