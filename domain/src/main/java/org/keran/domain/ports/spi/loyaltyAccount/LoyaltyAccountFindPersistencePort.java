package org.keran.domain.ports.spi.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccountTransactionHistory.LoyaltyAccountTransactionHistoryDto;

import java.util.List;
import java.util.UUID;

public interface LoyaltyAccountFindPersistencePort {
    LoyaltyAccountDto findLoyaltyAccountById(UUID accountId);
    LoyaltyAccountDto findLoyaltyAccountByNumber(String accountNumber);
    LoyaltyAccountTransactionHistoryDto findLoyaltyAccountTransactionHistoryById(UUID transactionHistoryId);
    List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId);
    List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountNumber(String accountNumber);
    boolean existsLoyaltyAccountById(UUID accountId);
}
