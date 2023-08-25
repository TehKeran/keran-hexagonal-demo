package org.keran.infrastructure.adapters.postgres.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyAccountUpdateAdapter implements LoyaltyAccountUpdatePersistencePort {
    @Override
    public LoyaltyAccountDto updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        return null;
    }
}
