package org.keran.domain.ports.spi.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

import java.util.Optional;

public interface LoyaltyAccountUpdatePersistencePort {
    Optional<LoyaltyAccountDto> updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
    Optional<LoyaltyAccountTransactionHistoryDto> updateLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);
}
