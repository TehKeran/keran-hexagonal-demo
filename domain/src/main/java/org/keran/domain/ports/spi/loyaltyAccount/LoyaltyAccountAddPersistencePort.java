package org.keran.domain.ports.spi.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

public interface LoyaltyAccountAddPersistencePort {
    LoyaltyAccountDto addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
    LoyaltyAccountTransactionHistoryDto addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);

}
