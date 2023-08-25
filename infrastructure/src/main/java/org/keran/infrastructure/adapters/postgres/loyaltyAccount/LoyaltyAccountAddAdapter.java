package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountTransactionHistoryDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountAddPersistencePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyAccountAddAdapter implements LoyaltyAccountAddPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(LoyaltyAccountAddAdapter.class);
    @Override
    public LoyaltyAccountDto addLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {

        return null;
    }

    @Override
    public LoyaltyAccountTransactionHistoryDto addLoyaltyAccountTransactionHistory(LoyaltyAccountTransactionHistoryDto loyaltyAccountTransactionHistoryDto) {
        return null;
    }
}
