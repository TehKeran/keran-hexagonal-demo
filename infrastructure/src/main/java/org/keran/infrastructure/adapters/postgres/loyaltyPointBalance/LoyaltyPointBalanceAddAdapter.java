package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceAddPersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyPointBalanceAddAdapter implements LoyaltyPointBalanceAddPersistencePort {
    @Override
    public LoyaltyPointBalanceDto addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        return null;
    }
}
