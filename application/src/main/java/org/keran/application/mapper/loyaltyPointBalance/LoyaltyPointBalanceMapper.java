package org.keran.application.mapper.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyPointBalanceMapper {
    LoyaltyPointBalanceMapper INSTANCE = Mappers.getMapper(LoyaltyPointBalanceMapper.class);
    @Mapping(source = "loyaltyAccountId", target = "loyaltyAccountDto.id")
    @Mapping(source = "loyaltyPointId", target = "loyaltyPointDto.id")
    LoyaltyPointBalanceDto loyaltyPointBalanceApiObjectToDto(LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject);
    @Mapping(source = "loyaltyAccountDto.id", target = "loyaltyAccountId")
    @Mapping(source = "loyaltyPointDto.id", target = "loyaltyPointId")
    LoyaltyPointBalanceApiObject loyaltyPointBalanceDtoToApiObject(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
    List<LoyaltyPointBalanceDto> loyaltyPointBalanceApiObjectListToDtoList(List<LoyaltyPointBalanceApiObject> loyaltyPointBalanceApiObjectList);
    List<LoyaltyPointBalanceApiObject> loyaltyPointBalanceDtoListToApiObjectList(List<LoyaltyPointBalanceDto> loyaltyPointBalanceDtoList);

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
