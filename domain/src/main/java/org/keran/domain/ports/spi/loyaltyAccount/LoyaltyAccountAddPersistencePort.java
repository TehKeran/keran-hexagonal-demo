package org.keran.domain.ports.spi.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;

import java.util.Optional;

public interface LoyaltyAccountAddPersistencePort {
    Optional<LoyaltyAccountDto> addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
    Optional<LoyaltyAccountTransactionHistoryDto> addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto);

}
