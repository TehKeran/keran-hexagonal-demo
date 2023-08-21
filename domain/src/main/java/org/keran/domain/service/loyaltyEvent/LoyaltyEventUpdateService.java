package org.keran.domain.service.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyEventUpdateService implements LoyaltyEventUpdateServicePort {
    private final LoyaltyEventUpdatePersistencePort loyaltyEventUpdatePersistencePort;

    public LoyaltyEventUpdateService(LoyaltyEventUpdatePersistencePort loyaltyEventUpdatePersistencePort) {
        this.loyaltyEventUpdatePersistencePort = loyaltyEventUpdatePersistencePort;
    }

    @Override
    public LoyaltyEventDto updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        return loyaltyEventUpdatePersistencePort.updateLoyaltyEvent(loyaltyEventDto);
    }

    @Override
    public LoyaltyEventConfigurationDto updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        return loyaltyEventUpdatePersistencePort.updateLoyaltyEventConfiguration(loyaltyEventConfigurationDto);
    }
}
