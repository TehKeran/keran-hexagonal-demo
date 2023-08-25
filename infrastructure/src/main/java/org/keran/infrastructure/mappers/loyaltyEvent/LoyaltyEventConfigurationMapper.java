package org.keran.infrastructure.mappers.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventConfigurationPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventConfigurationMapper {
    LoyaltyEventConfigurationMapper INSTANCE = Mappers.getMapper(LoyaltyEventConfigurationMapper.class);

    LoyaltyEventConfigurationDto loyaltyEventConfigurationPostgresToDto(
            LoyaltyEventConfigurationPostgres loyaltyEventConfigurationPostgres);
    LoyaltyEventConfigurationPostgres loyaltyEventConfigurationDtoToPostgres(
            LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
    List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationPostgresListToDtoList(
            List<LoyaltyEventConfigurationPostgres> loyaltyEventConfigurationPostgresList);
    List<LoyaltyEventConfigurationPostgres> loyaltyEventConfigurationDtoListToPostgresList(
            List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDtoList);

}
