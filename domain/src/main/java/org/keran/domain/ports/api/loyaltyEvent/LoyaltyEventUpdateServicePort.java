package org.keran.domain.ports.api.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

import java.util.Optional;

public interface LoyaltyEventUpdateServicePort {
    Optional<LoyaltyEventDto> updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
    Optional<LoyaltyEventConfigurationDto> updateLoyaltyEventConfiguration(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
}
