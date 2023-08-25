package org.keran.infrastructure.mappers.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.infrastructure.data.postgres.loyaltyCustomer.LoyaltyCustomerPostgres;
import org.keran.infrastructure.mappers.loyaltyCard.LoyaltyCardMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyCustomerMapper {
    LoyaltyCustomerMapper INSTANCE = Mappers.getMapper(LoyaltyCustomerMapper.class);

    LoyaltyCustomerDto loyaltyCustomerPostgresToDto(LoyaltyCustomerPostgres loyaltyCustomerPostgres);
    LoyaltyCustomerPostgres loyaltyCustomerDtoToPostgres(LoyaltyCustomerDto loyaltyCustomerDto);
    List<LoyaltyCustomerDto> loyaltyCustomerPostgresListToDtoList(List<LoyaltyCustomerPostgres> loyaltyCustomerPostgresList);
    List<LoyaltyCustomerPostgres> loyaltyCustomerDtoListToPostgresList(List<LoyaltyCustomerDto> loyaltyCustomerDtoList);

}
