package org.keran.domain.service.loyaltyCard;

import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyCardDeleteService implements LoyaltyCardDeleteServicePort {
    private final LoyaltyCardDeletePersistencePort loyaltyCardDeletePersistencePort;

    public LoyaltyCardDeleteService(LoyaltyCardDeletePersistencePort loyaltyCardDeletePersistencePort) {
        this.loyaltyCardDeletePersistencePort = loyaltyCardDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyCardById(UUID loyaltyCardId) {
        loyaltyCardDeletePersistencePort.deleteLoyaltyCardById(loyaltyCardId);
    }
}
