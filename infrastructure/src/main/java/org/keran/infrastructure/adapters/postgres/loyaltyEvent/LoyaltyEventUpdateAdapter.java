package org.keran.infrastructure.adapters.postgres.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.ports.spi.loyaltyEvent.LoyaltyEventUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyEventUpdateAdapter implements LoyaltyEventUpdatePersistencePort {
    @Override
    public LoyaltyEventDto updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto) {
        return null;
    }

    @Override
    public LoyaltyEventConfigurationDto updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto) {
        return null;
    }
}
