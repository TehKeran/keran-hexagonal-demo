package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyPointFindAdapter implements LoyaltyPointFindPersistencePort {
    @Override
    public LoyaltyPointDto findLoyaltyPointById(UUID id) {
        return null;
    }

    @Override
    public LoyaltyPointDto findLoyaltyPointByName(String name) {
        return null;
    }
}
