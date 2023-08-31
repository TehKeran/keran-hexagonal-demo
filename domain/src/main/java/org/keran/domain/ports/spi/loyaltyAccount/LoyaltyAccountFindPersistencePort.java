package org.keran.domain.ports.spi.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyAccountFindPersistencePort {
    Optional<LoyaltyAccountDto> findLoyaltyAccountById(UUID id);
    Optional<LoyaltyAccountDto> findLoyaltyAccountByNumber(String accountNumber);
    Optional<LoyaltyAccountTransactionHistoryDto> findLoyaltyAccountTransactionHistoryById(UUID id);
    List<LoyaltyAccountDto> getLoyaltyAccountsByLoyaltyCustomerId(UUID loyaltyCustomerId);
    List<LoyaltyAccountDto> getLoyaltyAccountsByLoyaltyProgramId(UUID loyaltyProgramId);
    List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId);
    boolean existsLoyaltyAccountById(UUID accountId);
    boolean existsLoyaltyAccountByAccountNumber(String accountNumber);
}
