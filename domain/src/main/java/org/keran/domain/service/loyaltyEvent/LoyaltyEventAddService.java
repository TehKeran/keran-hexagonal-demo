package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventAddServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventAddService implements LoyaltyEventAddServicePort {
    private final LoyaltyEventAddPersistencePort loyaltyEventAddPersistencePort;

    public LoyaltyEventAddService(LoyaltyEventAddPersistencePort loyaltyEventAddPersistencePort) {
        this.loyaltyEventAddPersistencePort = loyaltyEventAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyEventDto> addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        return loyaltyEventAddPersistencePort.addLoyaltyEvent(loyaltyEventDto);
    }

    @Override
    public Optional<LoyaltyEventConfigurationDto> addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        return loyaltyEventAddPersistencePort.addLoyaltyEventConfigurationDto(loyaltyEventConfigurationDto);
    }
}
