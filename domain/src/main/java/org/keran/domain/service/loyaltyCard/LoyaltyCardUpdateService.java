package org.keran.domain.service.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardUpdatePersistencePort;
import org.keran.domain.validator.loyaltyCard.LoyaltyCardValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCardUpdateService implements LoyaltyCardUpdateServicePort {
    private final LoyaltyCardUpdatePersistencePort loyaltyCardUpdatePersistencePort;
    private final LoyaltyCardValidator loyaltyCardValidator;

    public LoyaltyCardUpdateService(LoyaltyCardUpdatePersistencePort loyaltyCardUpdatePersistencePort, LoyaltyCardValidator loyaltyCardValidator) {
        this.loyaltyCardUpdatePersistencePort = loyaltyCardUpdatePersistencePort;
        this.loyaltyCardValidator = loyaltyCardValidator;
    }

    @Override
    public Optional<LoyaltyCardDto> updateLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        // Business validation
        loyaltyCardValidator.validateLoyaltyCardExists(loyaltyCardDto.getId());

        return loyaltyCardUpdatePersistencePort.updateLoyaltyCard(loyaltyCardDto);
    }
}
