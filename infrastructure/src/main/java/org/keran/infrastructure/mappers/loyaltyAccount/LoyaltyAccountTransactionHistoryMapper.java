package org.keran.infrastructure.mappers.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyAccountTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountTransactionHistoryPostgres;
import org.keran.infrastructure.utility.DefIdsUtility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyAccountTransactionHistoryMapper {
    LoyaltyAccountTransactionHistoryMapper INSTANCE = Mappers.getMapper(LoyaltyAccountTransactionHistoryMapper.class);

    @Mapping(source = "loyaltyAccountPostgres.id", target = "loyaltyAccountDto.id")
    LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryPostgresToDto(
            LoyaltyAccountTransactionHistoryPostgres loyaltyAccountTransactionHistoryPostgres);
    @Mapping(source = "loyaltyAccountDto.id", target = "loyaltyAccountPostgres.id")
    LoyaltyAccountTransactionHistoryPostgres loyaltyAccountTransactionHistoryDtoToPostgres(
            LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);
    List<LoyaltyAccountTransactionHistoryDto> loyaltyAccountTransactionHistoryPostgresListToDtoList(
            List<LoyaltyAccountTransactionHistoryPostgres> loyaltyAccountTransactionHistoryPostgresList);
    List<LoyaltyAccountTransactionHistoryPostgres> loyaltyAccountTransactionHistoryDtoListToPostgresList(
            List<LoyaltyAccountTransactionHistoryDto> loyaltyAccountTransactionHistoryDtoList);
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
