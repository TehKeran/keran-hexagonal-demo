package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountUpdatePersistencePort;

public class LoyaltyAccountUpdateAdapter implements LoyaltyAccountUpdatePersistencePort {
    @Override
    public LoyaltyAccountDto updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        return null;
    }
}
