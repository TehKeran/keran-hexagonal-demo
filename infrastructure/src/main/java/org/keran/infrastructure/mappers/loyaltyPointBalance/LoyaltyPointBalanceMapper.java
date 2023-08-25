package org.keran.infrastructure.mappers.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyPointBalanceMapper {
    LoyaltyPointBalanceMapper INSTANCE = Mappers.getMapper(LoyaltyPointBalanceMapper.class);

    LoyaltyPointBalanceDto loyaltyPointBalancePostgresToDto(LoyaltyPointBalancePostgres loyaltyPointBalancePostgres);
    LoyaltyPointBalancePostgres loyaltyPointBalanceDtoToPostgres(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
    List<LoyaltyPointBalanceDto> loyaltyPointBalancePostgresListToDtoList(List<LoyaltyPointBalancePostgres> loyaltyPointBalancePostgresList);
    List<LoyaltyPointBalancePostgres> loyaltyPointBalanceDtoListToPostgresList(List<LoyaltyPointBalanceDto> loyaltyPointBalanceDtoList);
}
