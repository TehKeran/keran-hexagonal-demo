package org.keran.domain.ports.spi.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

public interface LoyaltyEventUpdatePersistencePort {
    LoyaltyEventDto updateLoyaltyEvent(LoyaltyEventDto loyaltyEventDto);
}
