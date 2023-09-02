package org.keran.infrastructure.mappers.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyAccountTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.keran.infrastructure.utility.DefIdsUtility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyAccountMapper {
    LoyaltyAccountMapper INSTANCE = Mappers.getMapper(LoyaltyAccountMapper.class);

    @Mapping(source = "loyaltyCustomerPostgres.id", target = "loyaltyCustomerDto.id")
    @Mapping(source = "loyaltyProgramPostgres.id", target = "loyaltyProgramDto.id")
    LoyaltyAccountDto loyaltyAccountPostgresToDto(LoyaltyAccountPostgres loyaltyAccountPostgres);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerPostgres.id")
    @Mapping(source = "loyaltyProgramDto.id", target = "loyaltyProgramPostgres.id")
    LoyaltyAccountPostgres loyaltyAccountDtoToPostgres(LoyaltyAccountDto loyaltyAccountDto);
    List<LoyaltyAccountDto> loyaltyAccountPostgresListToDtoList(List<LoyaltyAccountPostgres> loyaltyAccountPostgresList);
    List<LoyaltyAccountPostgres> loyaltyAccountDtoListToPostgresList(List<LoyaltyAccountDto> loyaltyAccountDtoList);
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
