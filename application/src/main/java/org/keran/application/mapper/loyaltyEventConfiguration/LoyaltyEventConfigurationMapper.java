package org.keran.application.mapper.loyaltyEventConfiguration;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventConfigurationMapper {
    LoyaltyEventConfigurationMapper INSTANCE = Mappers.getMapper(LoyaltyEventConfigurationMapper.class);
    @Mapping(source = "loyaltyEventId", target = "loyaltyEventDto.id")
    @Mapping(source = "loyaltyProgramId", target = "loyaltyProgramDto.id")
    LoyaltyEventConfigurationDto loyaltyEventConfigurationApiObjectToDto(LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject);

    @Mapping(source = "loyaltyEventDto.id", target = "loyaltyEventId")
    @Mapping(source = "loyaltyProgramDto.id", target = "loyaltyProgramId")
    LoyaltyEventConfigurationApiObject loyaltyEventConfigurationDtoToApiObject(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
    List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationApiObjectListToDtoList(List<LoyaltyEventConfigurationApiObject> loyaltyEventConfigurationApiObjectList);
    List<LoyaltyEventConfigurationApiObject> loyaltyEventConfigurationDtoListToApiObjectList(List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDtoList);

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
