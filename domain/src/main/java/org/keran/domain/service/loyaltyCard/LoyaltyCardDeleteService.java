package org.keran.domain.service.loyaltyCard;

import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardDeletePersistencePort;
import org.keran.domain.validator.loyaltyCard.LoyaltyCardValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoyaltyCardDeleteService implements LoyaltyCardDeleteServicePort {
    private final LoyaltyCardDeletePersistencePort loyaltyCardDeletePersistencePort;
    private final LoyaltyCardValidator loyaltyCardValidator;


    public LoyaltyCardDeleteService(LoyaltyCardDeletePersistencePort loyaltyCardDeletePersistencePort, LoyaltyCardValidator loyaltyCardValidator) {
        this.loyaltyCardDeletePersistencePort = loyaltyCardDeletePersistencePort;
        this.loyaltyCardValidator = loyaltyCardValidator;
    }

    @Override
    public void deleteLoyaltyCardById(UUID loyaltyCardId) {
        // Business validation
        // - Entity must exist
        loyaltyCardValidator.validateLoyaltyCardExists(loyaltyCardId);

        loyaltyCardDeletePersistencePort.deleteLoyaltyCardById(loyaltyCardId);
    }

    @Override
    public void deleteAllLoyaltyCardByLoyaltyCustomerId(UUID loyaltyCustomerId) {
        loyaltyCardDeletePersistencePort.deleteAllLoyaltyCardByLoyaltyCustomerId(loyaltyCustomerId);
    }
}
