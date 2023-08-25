package org.keran.domain.ports.spi.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

public interface LoyaltyEventAddPersistencePort {
    LoyaltyEventDto addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
    LoyaltyEventConfigurationDto addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
}
