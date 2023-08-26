package org.keran.domain.ports.api.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

import java.util.Optional;

public interface LoyaltyAccountUpdateServicePort {
    Optional<LoyaltyAccountDto> updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
    Optional<LoyaltyAccountTransactionHistoryDto> updateLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);

}
