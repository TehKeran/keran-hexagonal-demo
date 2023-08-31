package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointUpdatePersistencePort;
import org.keran.domain.validator.loyaltyPoint.LoyaltyPointValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointUpdateService implements LoyaltyPointUpdateServicePort {
    private final LoyaltyPointUpdatePersistencePort loyaltyPointUpdatePersistencePort;
    private final LoyaltyPointValidator loyaltyPointValidator;

    public LoyaltyPointUpdateService(LoyaltyPointUpdatePersistencePort loyaltyPointUpdatePersistencePort, LoyaltyPointValidator loyaltyPointValidator) {
        this.loyaltyPointUpdatePersistencePort = loyaltyPointUpdatePersistencePort;
        this.loyaltyPointValidator = loyaltyPointValidator;
    }

    @Override
    public Optional<LoyaltyPointDto> updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        // Business validation
        // - Entity must exist
        loyaltyPointValidator.validateLoyaltyPointExists(loyaltyPointDto.getId());

        return loyaltyPointUpdatePersistencePort.updateLoyaltyPoint(loyaltyPointDto);
    }
}
