package org.keran.infrastructure.mappers.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyAccountTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyPointBalance.LoyaltyPointBalancePostgres;
import org.keran.infrastructure.utility.DefIdsUtility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyPointBalanceMapper {
    LoyaltyPointBalanceMapper INSTANCE = Mappers.getMapper(LoyaltyPointBalanceMapper.class);

    @Mapping(source = "loyaltyAccountPostgres.id", target = "loyaltyAccountDto.id")
    @Mapping(source = "loyaltyPointPostgres.id", target = "loyaltyPointDto.id")
    LoyaltyPointBalanceDto loyaltyPointBalancePostgresToDto(LoyaltyPointBalancePostgres loyaltyPointBalancePostgres);
    @Mapping(source = "loyaltyAccountDto.id", target = "loyaltyAccountPostgres.id")
    @Mapping(source = "loyaltyPointDto.id", target = "loyaltyPointPostgres.id")
    LoyaltyPointBalancePostgres loyaltyPointBalanceDtoToPostgres(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
    List<LoyaltyPointBalanceDto> loyaltyPointBalancePostgresListToDtoList(List<LoyaltyPointBalancePostgres> loyaltyPointBalancePostgresList);
    List<LoyaltyPointBalancePostgres> loyaltyPointBalanceDtoListToPostgresList(List<LoyaltyPointBalanceDto> loyaltyPointBalanceDtoList);

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
    static LoyaltyAccountTypeEnum map(DefLoyaltyAccountTypePostgres value){
        if (value == null) {
            return null;
        }

        return LoyaltyAccountTypeEnum.findByName(value.getValue());
    }
    static DefLoyaltyAccountTypePostgres map(LoyaltyAccountTypeEnum value) {
        if (value == null) {
            return null;
        }

        DefLoyaltyAccountTypePostgres defLoyaltyAccountTypePostgres = new DefLoyaltyAccountTypePostgres();
        defLoyaltyAccountTypePostgres.setValue(value.getName());
        defLoyaltyAccountTypePostgres.setId(DefIdsUtility.findDefAccountTypeId(value));
        return defLoyaltyAccountTypePostgres;
    }
}
