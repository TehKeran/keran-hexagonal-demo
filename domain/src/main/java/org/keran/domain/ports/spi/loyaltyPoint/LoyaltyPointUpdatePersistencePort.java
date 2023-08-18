package org.keran.domain.ports.spi.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

public interface LoyaltyPointUpdatePersistencePort {
    LoyaltyPointDto updateLoyaltyPoint(LoyaltyPointDto loyaltyPointDto);
}
