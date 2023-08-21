package org.keran.domain.ports.api.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

public interface LoyaltyEventAddServicePort {
    LoyaltyEventDto addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
    LoyaltyEventConfigurationDto addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
}
