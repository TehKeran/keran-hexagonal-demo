package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccountTransactionHistory.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountAddPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyAccountAddAdapter implements LoyaltyAccountAddPersistencePort {
    @Override
    public LoyaltyAccountDto addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        return null;
    }

    @Override
    public LoyaltyAccountTransactionHistoryDto addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        return null;
    }
}
