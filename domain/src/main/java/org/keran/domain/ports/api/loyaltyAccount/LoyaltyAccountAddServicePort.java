package org.keran.domain.ports.api.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccountTransactionHistory.LoyaltyAccountTransactionHistoryDto;

public interface LoyaltyAccountAddServicePort {
    LoyaltyAccountDto addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
    LoyaltyAccountTransactionHistoryDto addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);
}
