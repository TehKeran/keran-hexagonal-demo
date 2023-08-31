package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventUpdatePersistencePort;
import org.keran.domain.validator.loyaltyEvent.LoyaltyEventValidator;
import org.keran.domain.validator.loyaltyEventConfiguration.LoyaltyEventConfigurationValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventUpdateService implements LoyaltyEventUpdateServicePort {
    private final LoyaltyEventUpdatePersistencePort loyaltyEventUpdatePersistencePort;
    private final LoyaltyEventValidator loyaltyEventValidator;
    private final LoyaltyEventConfigurationValidator loyaltyEventConfigurationValidator;

    public LoyaltyEventUpdateService(LoyaltyEventUpdatePersistencePort loyaltyEventUpdatePersistencePort, LoyaltyEventValidator loyaltyEventValidator, LoyaltyEventConfigurationValidator loyaltyEventConfigurationValidator) {
        this.loyaltyEventUpdatePersistencePort = loyaltyEventUpdatePersistencePort;
        this.loyaltyEventValidator = loyaltyEventValidator;
        this.loyaltyEventConfigurationValidator = loyaltyEventConfigurationValidator;
    }

    @Override
    public Optional<LoyaltyEventDto> updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        // Business validation:
        // - Loyalty Event must exist:
        loyaltyEventValidator.validateLoyaltyEventExists(loyaltyEventDto.getId());

        return loyaltyEventUpdatePersistencePort.updateLoyaltyEvent(loyaltyEventDto);
    }

    @Override
    public Optional<LoyaltyEventConfigurationDto> updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        // Business validation
        // - entity must exist:
        loyaltyEventConfigurationValidator.validateLoyaltyEventConfigurationExists(loyaltyEventConfigurationDto.getId());

        return loyaltyEventUpdatePersistencePort.updateLoyaltyEventConfiguration(loyaltyEventConfigurationDto);
    }
}
