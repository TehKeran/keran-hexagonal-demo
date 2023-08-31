package org.keran.application.mapper.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.infrastructure.data.LoyaltyPointApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyPointMapper {
    LoyaltyPointMapper INSTANCE = Mappers.getMapper(LoyaltyPointMapper.class);
    LoyaltyPointDto loyaltyPointApiObjectToDto(LoyaltyPointApiObject loyaltyPointApiObject);
    LoyaltyPointApiObject loyaltyPointDtoToApiObject(LoyaltyPointDto loyaltyPointDto);
    List<LoyaltyPointDto> loyaltyPointApiObjectListToDtoList(List<LoyaltyPointApiObject> loyaltyPointApiObjectList);
    List<LoyaltyPointApiObject> loyaltyPointDtoListToApiObjectList(List<LoyaltyPointDto> loyaltyPointDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
