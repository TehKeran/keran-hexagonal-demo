package org.keran.domain.ports.api.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

public interface LoyaltyEventUpdateServicePort {
    LoyaltyEventDto updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
    LoyaltyEventConfigurationDto updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
}