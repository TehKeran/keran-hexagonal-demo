package org.keran.application.mapper.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventOccurrenceMapper {
    LoyaltyEventOccurrenceMapper INSTANCE = Mappers.getMapper(LoyaltyEventOccurrenceMapper.class);
    @Mapping(source = "loyaltyEventId", target = "loyaltyEventDto.id")
    @Mapping(source = "loyaltyCustomerId", target = "loyaltyCustomerDto.id")
    LoyaltyEventOccurrenceDto loyaltyEventOccurrenceApiObjectToDto(LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject);
    @Mapping(source = "loyaltyEventDto.id", target = "loyaltyEventId")
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerId")
    LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceDtoToApiObject(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
    List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceApiObjectListToDtoList(List<LoyaltyEventOccurrenceApiObject> loyaltyEventOccurrenceApiObjectList);
    List<LoyaltyEventOccurrenceApiObject> loyaltyEventOccurrenceDtoListToApiObjectList(List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDtoList);

    static LocalDateTime map(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.atStartOfDay();
    }
    static LocalDate map(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        return dateTime.toLocalDate();
    }
}
