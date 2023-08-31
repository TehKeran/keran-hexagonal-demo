package org.keran.domain.service.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointFindServicePort;
import org.keran.domain.ports.spi.loyaltyPoint.LoyaltyPointFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoyaltyPointFindService implements LoyaltyPointFindServicePort {
    private final LoyaltyPointFindPersistencePort loyaltyPointFindPersistencePort;

    public LoyaltyPointFindService(LoyaltyPointFindPersistencePort loyaltyPointFindPersistencePort) {
        this.loyaltyPointFindPersistencePort = loyaltyPointFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyPointDto> findLoyaltyPointById(UUID id) {
        return loyaltyPointFindPersistencePort.findLoyaltyPointById(id);
    }

    @Override
    public Optional<LoyaltyPointDto> findLoyaltyPointByName(String name) {
        return loyaltyPointFindPersistencePort.findLoyaltyPointByName(name);
    }

    @Override
    public boolean existsById(UUID id) {
        return loyaltyPointFindPersistencePort.existsById(id);
    }

}
