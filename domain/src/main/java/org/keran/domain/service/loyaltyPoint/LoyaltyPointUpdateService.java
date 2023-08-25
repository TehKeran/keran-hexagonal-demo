package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyPointUpdateService implements LoyaltyPointUpdateServicePort {
    private final LoyaltyPointUpdatePersistencePort loyaltyPointUpdatePersistencePort;

    public LoyaltyPointUpdateService(LoyaltyPointUpdatePersistencePort loyaltyPointUpdatePersistencePort) {
        this.loyaltyPointUpdatePersistencePort = loyaltyPointUpdatePersistencePort;
    }

    @Override
    public LoyaltyPointDto updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        return loyaltyPointUpdatePersistencePort.updateLoyaltyPoint(loyaltyPointDto);
    }
}
