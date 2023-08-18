package org.keran.domain.ports.api.loyaltyEvent;

import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

import java.util.UUID;

public interface LoyaltyEventFindServicePort {
    LoyaltyEventDto findLoyaltyEventById(UUID id);
    LoyaltyEventDto findLoyaltyEventByName(String name);
}
