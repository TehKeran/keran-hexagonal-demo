package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointBalanceDeleteService implements LoyaltyPointBalanceDeleteServicePort {
    private final LoyaltyPointBalanceDeletePersistencePort loyaltyPointBalanceDeletePersistencePort;

    public LoyaltyPointBalanceDeleteService(LoyaltyPointBalanceDeletePersistencePort loyaltyPointBalanceDeletePersistencePort) {
        this.loyaltyPointBalanceDeletePersistencePort = loyaltyPointBalanceDeletePersistencePort;
    }

    @Override
    public void deleteLoyaltyPointBalanceById(UUID id) {
        loyaltyPointBalanceDeletePersistencePort.deleteLoyaltyPointBalanceById(id);
    }
}
