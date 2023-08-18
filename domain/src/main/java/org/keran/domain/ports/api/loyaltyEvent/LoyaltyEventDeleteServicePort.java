package org.keran.domain.ports.api.loyaltyEvent;

import java.util.UUID;

public interface LoyaltyEventDeleteServicePort {
    void deleteLoyaltyEventById(UUID id);
}
