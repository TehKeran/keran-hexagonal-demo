package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountFindServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoyaltyAccountFindService implements LoyaltyAccountFindServicePort {
    private final LoyaltyAccountFindPersistencePort loyaltyAccountFindPersistencePort;

    public LoyaltyAccountFindService(LoyaltyAccountFindPersistencePort loyaltyAccountFindPersistencePort) {
        this.loyaltyAccountFindPersistencePort = loyaltyAccountFindPersistencePort;
    }

    @Override
    public LoyaltyAccountDto findLoyaltyAccountById(UUID accountId) {
        return loyaltyAccountFindPersistencePort.findLoyaltyAccountById(accountId);
    }

    @Override
    public LoyaltyAccountDto findLoyaltyAccountByNumber(String accountNumber) {
        return loyaltyAccountFindPersistencePort.findLoyaltyAccountByNumber(accountNumber);
    }

    @Override
    public LoyaltyAccountTransactionHistoryDto findLoyaltyAccountTransactionHistoryById(UUID transactionHistoryId) {
        return loyaltyAccountFindPersistencePort.findLoyaltyAccountTransactionHistoryById(transactionHistoryId);
    }

    @Override
    public List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId) {
        return loyaltyAccountFindPersistencePort.getLoyaltyAccountTransactionHistoryByAccountId(accountId);
    }

    @Override
    public List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountNumber(String accountNumber) {
        return loyaltyAccountFindPersistencePort.getLoyaltyAccountTransactionHistoryByAccountNumber(accountNumber);
    }

    @Override
    public boolean existsLoyaltyAccountById(UUID accountId) {
        return loyaltyAccountFindPersistencePort.existsLoyaltyAccountById(accountId);
    }
}
