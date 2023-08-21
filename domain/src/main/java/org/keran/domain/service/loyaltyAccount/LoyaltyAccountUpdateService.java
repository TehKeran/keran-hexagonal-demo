package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyAccountUpdateService implements LoyaltyAccountUpdateServicePort {
    private final LoyaltyAccountUpdatePersistencePort loyaltyAccountUpdatePersistencePort;

    public LoyaltyAccountUpdateService(LoyaltyAccountUpdatePersistencePort loyaltyAccountUpdatePersistencePort) {
        this.loyaltyAccountUpdatePersistencePort = loyaltyAccountUpdatePersistencePort;
    }

    @Override
    public LoyaltyAccountDto updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto) {
        return loyaltyAccountUpdatePersistencePort.updateLoyaltyAccount(loyaltyAccountDto);
    }
}
