package org.keran.infrastructure.adapters.postgres.loyaltyPoint;

import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyPointDeleteAdapter implements LoyaltyPointDeletePersistencePort {
    @Override
    public void deleteLoyaltyPointById(UUID id) {

    }
}
