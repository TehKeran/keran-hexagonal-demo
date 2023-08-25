package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyPointUpdateAdapter implements LoyaltyPointUpdatePersistencePort {
    @Override
    public LoyaltyPointDto updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        return null;
    }
}
