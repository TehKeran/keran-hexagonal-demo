package org.keran.domain.ports.spi.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

public interface LoyaltyEventUpdatePersistencePort {
    LoyaltyEventDto updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
    LoyaltyEventConfigurationDto updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
}
