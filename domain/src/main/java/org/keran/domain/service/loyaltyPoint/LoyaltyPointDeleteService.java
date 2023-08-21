package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointDeleteService implements LoyaltyPointDeleteServicePort {
    private final LoyaltyPointDeletePersistencePort loyaltyPointDeletePersistencePort;

    public LoyaltyPointDeleteService(LoyaltyPointDeletePersistencePort loyaltyPointDeletePersistencePort) {
        this.loyaltyPointDeletePersistencePort = loyaltyPointDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyPointById(UUID id) {
        loyaltyPointDeletePersistencePort.deleteLoyaltyPointById(id);
    }
}
