package org.keran.domain.ports.api.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyAccountFindServicePort {
    Optional<LoyaltyAccountDto> findLoyaltyAccountById(UUID id);
    Optional<LoyaltyAccountDto> findLoyaltyAccountByNumber(String accountNumber);
    Optional<LoyaltyAccountTransactionHistoryDto> findLoyaltyAccountTransactionHistoryById(UUID id);
    List<LoyaltyAccountTransactionHistoryDto> getLoyaltyAccountTransactionHistoryByAccountId(UUID accountId);
    boolean existsLoyaltyAccountById(UUID accountId);
}

