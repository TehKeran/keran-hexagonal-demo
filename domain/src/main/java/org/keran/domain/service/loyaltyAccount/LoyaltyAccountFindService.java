package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountFindServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoyaltyAccountFindService implements LoyaltyAccountFindServicePort {
    private final LoyaltyAccountFindPersistencePort loyaltyAccountFindPersistencePort;

    public LoyaltyAccountFindService(LoyaltyAccountFindPersistencePort loyaltyAccountFindPersistencePort) {
        this.loyaltyAccountFindPersistencePort = loyaltyAccountFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyAccountDto> findLoyaltyAccountById(UUID id) {
        return loyaltyAccountFindPersistencePort.findLoyaltyAccountById(id);
    }

    @Override
    public Optional<LoyaltyAccountDto> findLoyaltyAccountByNumber(String accountNumber) {
        return loyaltyAccountFindPersistencePort.findLoyaltyAccountByNumber(accountNumber);
    }

    @Override
    public Optional<LoyaltyAccountTransactionHistoryDto> findLoyaltyAccountTransactionHistoryById(UUID id) {
        return loyaltyAccountFindPersistencePort.findLoyaltyAccountTransactionHistoryById(id);
    }

    @Override
    public List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId) {
        return loyaltyAccountFindPersistencePort.getLoyaltyAccountTransactionHistoryByAccountId(accountId);
    }

    @Override
    public boolean existsLoyaltyAccountById(UUID accountId) {
        return loyaltyAccountFindPersistencePort.existsLoyaltyAccountById(accountId);
    }

    @Override
    public List<LoyaltyAccountDto> getLoyaltyAccountsByLoyaltyCustomerId(UUID loyaltyCustomerId) {
        return loyaltyAccountFindPersistencePort.getLoyaltyAccountsByLoyaltyCustomerId(loyaltyCustomerId);
    }

    @Override
    public boolean existsLoyaltyAccountByAccountNumber(String accountNumber) {
        return loyaltyAccountFindPersistencePort.existsLoyaltyAccountByAccountNumber(accountNumber);
    }

    @Override
    public List<LoyaltyAccountDto> getLoyaltyAccountsByLoyaltyProgramId(UUID loyaltyProgramId) {
        return loyaltyAccountFindPersistencePort.getLoyaltyAccountsByLoyaltyProgramId(loyaltyProgramId);
    }
}
