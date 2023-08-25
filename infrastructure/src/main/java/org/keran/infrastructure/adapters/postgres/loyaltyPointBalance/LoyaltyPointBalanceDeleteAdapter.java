package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceDeletePersistencePort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class LoyaltyPointBalanceDeleteAdapter implements LoyaltyPointBalanceDeletePersistencePort {
    @Override
    public void deleteLoyaltyPointBalanceById(UUID id) {

    }
}
