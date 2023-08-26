package org.keran.domain.ports.api.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

import java.util.Optional;

public interface LoyaltyAccountAddServicePort {
    Optional<LoyaltyAccountDto> addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
    Optional<LoyaltyAccountTransactionHistoryDto> addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);
}
