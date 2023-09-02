package org.keran.infrastructure.mappers.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.definition.LoyaltyCardTypeEnum;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyCardTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyCard.LoyaltyCardPostgres;
import org.keran.infrastructure.utility.DefIdsUtility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyCardMapper {
    LoyaltyCardMapper INSTANCE = Mappers.getMapper(LoyaltyCardMapper.class);

    @Mapping(source = "loyaltyCustomerPostgres.id", target = "loyaltyCustomerDto.id")
    LoyaltyCardDto loyaltyCardPostgresToDto(LoyaltyCardPostgres loyaltyCardPostgres);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerPostgres.id")
    LoyaltyCardPostgres loyaltyCardDtoToPostgres(LoyaltyCardDto loyaltyCardDto);
    List<LoyaltyCardDto> loyaltyCardPostgresListToDtoList(List<LoyaltyCardPostgres> loyaltyCardPostgresList);
    List<LoyaltyCardPostgres> loyaltyCardDtoListToPostgresList(List<LoyaltyCardDto> loyaltyCardDtoList);

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
    static LoyaltyCardTypeEnum map(DefLoyaltyCardTypePostgres value) {
        if (value == null) {
            return null;
        }

        return LoyaltyCardTypeEnum.findByName(value.getValue());
    }
    static DefLoyaltyCardTypePostgres map(LoyaltyCardTypeEnum value) {
        if (value == null) {
            return null;
        }

        DefLoyaltyCardTypePostgres defLoyaltyCardTypePostgres = new DefLoyaltyCardTypePostgres();
        defLoyaltyCardTypePostgres.setValue(value.getName());
        defLoyaltyCardTypePostgres.setId(DefIdsUtility.findDefLoyaltyCardTypeId(value));
        return defLoyaltyCardTypePostgres;
    }
}
