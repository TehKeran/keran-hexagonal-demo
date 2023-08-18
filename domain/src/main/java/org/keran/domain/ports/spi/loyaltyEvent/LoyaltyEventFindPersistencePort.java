package org.keran.domain.ports.spi.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

import java.util.UUID;

public interface LoyaltyEventFindPersistencePort {
    LoyaltyEventDto findLoyaltyEventById(UUID id);
    LoyaltyEventDto findLoyaltyEventByName(String name);
}
