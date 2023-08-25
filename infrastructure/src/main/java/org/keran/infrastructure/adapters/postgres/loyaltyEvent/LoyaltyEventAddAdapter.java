package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyEventAddAdapter implements LoyaltyEventAddPersistencePort {
    @Override
    public LoyaltyEventDto addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        return null;
    }

    @Override
    public LoyaltyEventConfigurationDto addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        return null;
    }
}
