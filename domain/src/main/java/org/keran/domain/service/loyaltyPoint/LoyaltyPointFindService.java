package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointFindServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointFindService implements LoyaltyPointFindServicePort {
    private final LoyaltyPointFindPersistencePort loyaltyPointFindPersistencePort;

    public LoyaltyPointFindService(LoyaltyPointFindPersistencePort loyaltyPointFindPersistencePort) {
        this.loyaltyPointFindPersistencePort = loyaltyPointFindPersistencePort;
    }

    @Override
    public LoyaltyPointDto findLoyaltyPointById(UUID id) {
        return loyaltyPointFindPersistencePort.findLoyaltyPointById(id);
    }

    @Override
    public LoyaltyPointDto findLoyaltyPointByName(String name) {
        return loyaltyPointFindPersistencePort.findLoyaltyPointByName(name);
    }
}
