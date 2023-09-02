package org.keran.infrastructure.mappers.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.infrastructure.data.postgres.loyaltyEventOccurrence.LoyaltyEventOccurrencePostgres;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventOccurrenceMapper {
    LoyaltyEventOccurrenceMapper INSTANCE = Mappers.getMapper(LoyaltyEventOccurrenceMapper.class);

    @Mapping(source = "loyaltyCustomerPostgres.id", target = "loyaltyCustomerDto.id")
    @Mapping(source = "loyaltyEventPostgres.id", target = "loyaltyEventDto.id")
    LoyaltyEventOccurrenceDto loyaltyEventOccurrencePostgresToDto(LoyaltyEventOccurrencePostgres loyaltyEventOccurrencePostgres);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerPostgres.id")
    @Mapping(source = "loyaltyEventDto.id", target = "loyaltyEventPostgres.id")
    LoyaltyEventOccurrencePostgres loyaltyEventOccurrenceDtoToPostgres(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
    List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrencePostgresListToDtoList(
            List<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrencePostgresList);
    List<LoyaltyEventOccurrencePostgres> loyaltyEventOccurrenceDtoListToPostgresList(
            List<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDtoList);
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
