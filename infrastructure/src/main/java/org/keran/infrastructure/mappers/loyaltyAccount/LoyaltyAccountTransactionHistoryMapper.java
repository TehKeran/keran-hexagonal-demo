package org.keran.infrastructure.mappers.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountTransactionHistoryPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyAccountTransactionHistoryMapper {
    LoyaltyAccountTransactionHistoryMapper INSTANCE = Mappers.getMapper(LoyaltyAccountTransactionHistoryMapper.class);

    LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryPostgresToDto(
            LoyaltyAccountTransactionHistoryPostgres loyaltyAccountTransactionHistoryPostgres);
    LoyaltyAccountTransactionHistoryPostgres loyaltyAccountTransactionHistoryDtoToPostgres(
            LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);
    List<LoyaltyAccountTransactionHistoryDto> loyaltyAccountTransactionHistoryPostgresListToDtoList(
            List<LoyaltyAccountTransactionHistoryPostgres> loyaltyAccountTransactionHistoryPostgresList);
    List<LoyaltyAccountTransactionHistoryPostgres> loyaltyAccountTransactionHistoryDtoListToPostgresList(
            List<LoyaltyAccountTransactionHistoryDto> loyaltyAccountTransactionHistoryDtoList);

}
