package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointAddServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointAddPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyPointAddService implements LoyaltyPointAddServicePort {
    private final LoyaltyPointAddPersistencePort loyaltyPointAddPersistencePort;

    public LoyaltyPointAddService(LoyaltyPointAddPersistencePort loyaltyPointAddPersistencePort) {
        this.loyaltyPointAddPersistencePort = loyaltyPointAddPersistencePort;
    }

    @Override
    public LoyaltyPointDto addLoyaltyPoint(LoyaltyPointDto loyaltyPointDto) {
        return loyaltyPointAddPersistencePort.addLoyaltyPoint(loyaltyPointDto);
    }
}
