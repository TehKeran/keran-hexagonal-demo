package org.keran.infrastructure.mappers.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.infrastructure.data.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrencePostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventOccurrenceMapper {
    LoyaltyEventOccurrenceMapper INSTANCE = Mappers.getMapper(LoyaltyEventOccurrenceMapper.class);

    LoyaltyEventOccurrenceDto loyaltyEventOccurrencePostgresToDto(LoyaltyEventOccurrencePostgres loyaltyEventOccurrencePostgres);
    LoyaltyEventOccurrencePostgres loyaltyEventOccurrenceDtoToPostgres(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
    List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrencePostgresListToDtoList(
            List<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrencePostgresList);
    List<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrenceDtoListToPostgresList(
            List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDtoList);
}
