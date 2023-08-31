package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointDeletePersistencePort;
import org.keran.domain.validator.loyaltyPoint.LoyaltyPointValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointDeleteService implements LoyaltyPointDeleteServicePort {
    private final LoyaltyPointDeletePersistencePort loyaltyPointDeletePersistencePort;
    private final LoyaltyPointValidator loyaltyPointValidator;

    public LoyaltyPointDeleteService(LoyaltyPointDeletePersistencePort loyaltyPointDeletePersistencePort, LoyaltyPointValidator loyaltyPointValidator) {
        this.loyaltyPointDeletePersistencePort = loyaltyPointDeletePersistencePort;
        this.loyaltyPointValidator = loyaltyPointValidator;
    }

    @Override
    public void deleteLoyaltyPointById(UUID id) {
        // Business validation
        // - Loyalty Point must exist
        loyaltyPointValidator.validateLoyaltyPointExists(id);

        loyaltyPointDeletePersistencePort.deleteLoyaltyPointById(id);
    }
}
