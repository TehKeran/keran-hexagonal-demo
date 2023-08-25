package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service

public class LoyaltyPointBalanceUpdateAdapter implements LoyaltyPointBalanceUpdatePersistencePort {
    @Override
    public LoyaltyPointBalanceDto updateLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        return null;
    }
}
