package org.keran.domain.ports.spi.loyaltyPoint;

import java.util.UUID;

public interface LoyaltyPointDeletePersistencePort {
    void deleteLoyaltyPointById(UUID id);
}
