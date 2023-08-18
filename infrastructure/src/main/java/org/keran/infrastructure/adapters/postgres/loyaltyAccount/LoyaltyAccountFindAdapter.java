package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccountTransactionHistory.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountFindPersistencePort;

import java.util.List;
import java.util.UUID;

public class LoyaltyAccountFindAdapter implements LoyaltyAccountFindPersistencePort {
    @Override
    public LoyaltyAccountDto findLoyaltyAccountById(UUID accountId) {
        return null;
    }

    @Override
    public LoyaltyAccountDto findLoyaltyAccountByNumber(String accountNumber) {
        return null;
    }

    @Override
    public LoyaltyAccountTransactionHistoryDto findLoyaltyAccountTransactionHistoryById(UUID transactionHistoryId) {
        return null;
    }

    @Override
    public List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId) {
        return null;
    }

    @Override
    public List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public boolean existsLoyaltyAccountById(UUID accountId) {
        return false;
    }
}
