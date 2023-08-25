package org.keran.domain.service.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyCardUpdateService implements LoyaltyCardUpdateServicePort {
    private final LoyaltyCardUpdatePersistencePort loyaltyCardUpdatePersistencePort;

    public LoyaltyCardUpdateService(LoyaltyCardUpdatePersistencePort loyaltyCardUpdatePersistencePort) {
        this.loyaltyCardUpdatePersistencePort = loyaltyCardUpdatePersistencePort;
    }

    @Override
    public LoyaltyCardDto updateLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        return loyaltyCardUpdatePersistencePort.updateLoyaltyCard(loyaltyCardDto);
    }
}
