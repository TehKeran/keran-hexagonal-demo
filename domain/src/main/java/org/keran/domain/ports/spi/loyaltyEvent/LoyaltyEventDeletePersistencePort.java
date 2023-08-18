package org.keran.domain.ports.spi.loyaltyEvent;

import java.util.UUID;

public interface LoyaltyEventDeletePersistencePort {
    void deleteLoyaltyEventById(UUID id);
}
