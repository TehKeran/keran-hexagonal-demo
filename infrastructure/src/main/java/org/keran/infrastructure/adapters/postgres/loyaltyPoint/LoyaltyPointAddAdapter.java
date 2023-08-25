package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyPointAddAdapter implements LoyaltyPointAddPersistencePort {
    @Override
    public LoyaltyPointDto addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        return null;
    }
}
