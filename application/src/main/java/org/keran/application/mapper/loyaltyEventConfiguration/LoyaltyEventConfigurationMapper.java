package org.keran.application.mapper.loyaltyEventConfiguration;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventConfigurationMapper {
    LoyaltyEventConfigurationMapper INSTANCE = Mappers.getMapper(LoyaltyEventConfigurationMapper.class);
    LoyaltyEventConfigurationDto loyaltyEventConfigurationApiObjectToDto(LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject);
    LoyaltyEventConfigurationApiObject loyaltyEventConfigurationDtoToApiObject(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
    List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationApiObjectListToDtoList(List<LoyaltyEventConfigurationApiObject> loyaltyEventConfigurationApiObjectList);
    List<LoyaltyEventConfigurationApiObject> loyaltyEventConfigurationDtoListToApiObjectList(List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
