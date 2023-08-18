package org.keran.domain.ports.api.loyaltyPoint;

import java.util.UUID;

public interface LoyaltyPointDeleteServicePort {
    void deleteLoyaltyPointById(UUID id);
}
