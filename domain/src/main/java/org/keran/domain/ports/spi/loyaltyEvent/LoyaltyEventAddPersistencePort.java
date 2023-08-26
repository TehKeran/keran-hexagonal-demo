package org.keran.domain.ports.spi.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

import java.util.Optional;

public interface LoyaltyEventAddPersistencePort {
    Optional<LoyaltyEventDto> addLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
    Optional<LoyaltyEventConfigurationDto> addLoyaltyEventConfigurationDto(LoyaltyEventConfigurationDto loyaltyEventConfigurationDto);
}
