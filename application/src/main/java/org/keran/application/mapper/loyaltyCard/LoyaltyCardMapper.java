package org.keran.application.mapper.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyCardMapper {
    LoyaltyCardMapper INSTANCE = Mappers.getMapper(LoyaltyCardMapper.class);
    @Mapping(source = "loyaltyCustomerId", target = "loyaltyCustomerDto.id")
    LoyaltyCardDto loyaltyCardApiObjectToDto(LoyaltyCardApiObject loyaltyCardApiObject);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerId")
    LoyaltyCardApiObject loyaltyCardDtoToApiObject(LoyaltyCardDto loyaltyCardDto);
    List<LoyaltyCardDto> loyaltyCardApiObjectListToDtoList(List<LoyaltyCardApiObject> loyaltyCardApiObjectList);
    List<LoyaltyCardApiObject> loyaltyCardDtoListToApiObjectList(List<LoyaltyCardDto> loyaltyCardDtoList);

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
