package org.keran.application.mapper.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyCardMapper {
    LoyaltyCardMapper INSTANCE = Mappers.getMapper(LoyaltyCardMapper.class);
    LoyaltyCardDto loyaltyCardApiObjectToDto(LoyaltyCardApiObject loyaltyCardApiObject);
    LoyaltyCardApiObject loyaltyCardDtoToApiObject(LoyaltyCardDto loyaltyCardDto);
    List<LoyaltyCardDto> loyaltyCardApiObjectListToDtoList(List<LoyaltyCardApiObject> loyaltyCardApiObjectList);
    List<LoyaltyCardApiObject> loyaltyCardDtoListToApiObjectList(List<LoyaltyCardDto> loyaltyCardDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
