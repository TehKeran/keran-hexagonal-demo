package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointAddServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointAddPersistencePort;
import org.keran.domain.validator.loyaltyPoint.LoyaltyPointValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointAddService implements LoyaltyPointAddServicePort {
    private final LoyaltyPointAddPersistencePort loyaltyPointAddPersistencePort;
    private final LoyaltyPointValidator loyaltyPointValidator;

    public LoyaltyPointAddService(LoyaltyPointAddPersistencePort loyaltyPointAddPersistencePort, LoyaltyPointValidator loyaltyPointValidator) {
        this.loyaltyPointAddPersistencePort = loyaltyPointAddPersistencePort;
        this.loyaltyPointValidator = loyaltyPointValidator;
    }

    @Override
    public Optional<LoyaltyPointDto> addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        // Domain validation
        // - If ID is provided - Entity must not exist
        if (loyaltyPointDto.getId() != null) {
            loyaltyPointValidator.validateLoyaltyPointNotExists(loyaltyPointDto.getId());
        }

        return loyaltyPointAddPersistencePort.addLoyaltyPoint(loyaltyPointDto);
    }
}
