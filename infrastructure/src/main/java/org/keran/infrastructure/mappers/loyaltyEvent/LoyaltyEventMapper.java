package org.keran.infrastructure.mappers.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventMapper {
    LoyaltyEventMapper INSTANCE = Mappers.getMapper(LoyaltyEventMapper.class);

    LoyaltyEventDto loyaltyEventPostgresToDto(LoyaltyEventPostgres loyaltyEventPostgres);
    LoyaltyEventPostgres loyaltyEventDtoToPostgres(LoyaltyEventDto loyaltyEventDto);
    List<LoyaltyEventPostgres> loyaltyEventDtoListToPostgresList(List<LoyaltyEventDto> loyaltyEventDtoList);
    List<LoyaltyEventDto> loyaltyEventPostgresListToDtoList(List<LoyaltyEventPostgres> loyaltyEventPostgresList);
}
