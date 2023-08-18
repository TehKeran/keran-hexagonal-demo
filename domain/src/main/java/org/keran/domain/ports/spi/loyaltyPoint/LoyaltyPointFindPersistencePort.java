package org.keran.domain.ports.spi.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.UUID;

public interface LoyaltyPointFindPersistencePort {
    LoyaltyPointDto findLoyaltyPointById(UUID id);
    LoyaltyPointDto findLoyaltyPointByName(String name);
}
