package org.keran.application.mapper.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyPointBalanceMapper {
    LoyaltyPointBalanceMapper INSTANCE = Mappers.getMapper(LoyaltyPointBalanceMapper.class);
    LoyaltyPointBalanceDto loyaltyPointBalanceApiObjectToDto(LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject);
    LoyaltyPointBalanceApiObject loyaltyPointBalanceDtoToApiObject(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
    List<LoyaltyPointBalanceDto> loyaltyPointBalanceApiObjectListToDtoList(List<LoyaltyPointBalanceApiObject> loyaltyPointBalanceApiObjectList);
    List<LoyaltyPointBalanceApiObject> loyaltyPointBalanceDtoListToApiObjectList(List<LoyaltyPointBalanceDto> loyaltyPointBalanceDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
