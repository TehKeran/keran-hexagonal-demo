package org.keran.domain.ports.spi.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

import java.util.Optional;

public interface LoyaltyPointAddPersistencePort {
    Optional<LoyaltyPointDto> addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto);
}
