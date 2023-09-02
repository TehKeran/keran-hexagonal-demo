package org.keran.infrastructure.mappers.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.infrastructure.data.postgres.loyaltyEvent.LoyaltyEventConfigurationPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyEventConfigurationMapper {
    LoyaltyEventConfigurationMapper INSTANCE = Mappers.getMapper(LoyaltyEventConfigurationMapper.class);

    @Mapping(source = "loyaltyProgramPostgres.id", target = "loyaltyProgramDto.id")
    @Mapping(source = "loyaltyEventPostgres.id", target = "loyaltyEventDto.id")
    LoyaltyEventConfigurationDto loyaltyEventConfigurationPostgresToDto(
            LoyaltyEventConfigurationPostgres loyaltyEventConfigurationPostgres);
    @Mapping(source = "loyaltyProgramDto.id", target = "loyaltyProgramPostgres.id")
    @Mapping(source = "loyaltyEventDto.id", target = "loyaltyEventPostgres.id")
    LoyaltyEventConfigurationPostgres loyaltyEventConfigurationDtoToPostgres(
            LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
    List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationPostgresListToDtoList(
            List<LoyaltyEventConfigurationPostgres> loyaltyEventConfigurationPostgresList);
    List<LoyaltyEventConfigurationPostgres> loyaltyEventConfigurationDtoListToPostgresList(
            List<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDtoList);

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
