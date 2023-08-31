package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventAddServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventAddPersistencePort;
import org.keran.domain.validator.loyaltyEvent.LoyaltyEventValidator;
import org.keran.domain.validator.loyaltyEventConfiguration.LoyaltyEventConfigurationValidator;
import org.keran.domain.validator.loyaltyProgram.LoyaltyProgramValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventAddService implements LoyaltyEventAddServicePort {
    private final LoyaltyEventAddPersistencePort loyaltyEventAddPersistencePort;
    private final LoyaltyEventValidator loyaltyEventValidator;
    private final LoyaltyEventConfigurationValidator loyaltyEventConfigurationValidator;
    private final LoyaltyProgramValidator loyaltyProgramValidator;

    public LoyaltyEventAddService(LoyaltyEventAddPersistencePort loyaltyEventAddPersistencePort, LoyaltyEventValidator loyaltyEventValidator, LoyaltyEventConfigurationValidator loyaltyEventConfigurationValidator, LoyaltyProgramValidator loyaltyProgramValidator) {
        this.loyaltyEventAddPersistencePort = loyaltyEventAddPersistencePort;
        this.loyaltyEventValidator = loyaltyEventValidator;
        this.loyaltyEventConfigurationValidator = loyaltyEventConfigurationValidator;
        this.loyaltyProgramValidator = loyaltyProgramValidator;
    }

    @Override
    public Optional<LoyaltyEventDto> addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        // Business validation:
        // - if ID is provided, it has to be unique:
        if (loyaltyEventDto.getId() != null) {
            loyaltyEventValidator.validateLoyaltyEventNotExists(loyaltyEventDto.getId());
        }
        // - name has to be unique:
        loyaltyEventValidator.validateLoyaltyEventNotExistsByName(loyaltyEventDto.getName());

        return loyaltyEventAddPersistencePort.addLoyaltyEvent(loyaltyEventDto);
    }

    @Override
    public Optional<LoyaltyEventConfigurationDto> addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        // Business validation
        // - If ID is provided, it must be unique
        if (loyaltyEventConfigurationDto.getId() != null) {
            loyaltyEventConfigurationValidator.validateLoyaltyEventConfigurationNotExists(loyaltyEventConfigurationDto.getId());
        }
        // - Loyalty program exists
        loyaltyProgramValidator.validateLoyaltyProgramExists(loyaltyEventConfigurationDto.getLoyaltyProgramDto().getId());
        // - Loyalty event exists
        loyaltyEventValidator.validateLoyaltyEventExists(loyaltyEventConfigurationDto.getLoyaltyEventDto().getId());
        // - Configuration for this loyalty event and program doesn't already exist
        loyaltyEventConfigurationValidator.validateLoyaltyEventConfigurationNotExistsByLoyaltyEventAndProgram(
                loyaltyEventConfigurationDto.getLoyaltyEventDto().getId(), loyaltyEventConfigurationDto.getLoyaltyProgramDto().getId());

        return loyaltyEventAddPersistencePort.addLoyaltyEventConfigurationDto(loyaltyEventConfigurationDto);
    }
}
