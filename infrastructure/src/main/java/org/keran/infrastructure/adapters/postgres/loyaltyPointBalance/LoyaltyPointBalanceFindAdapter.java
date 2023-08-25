package org.keran.infrastructure.adapters.postgres.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class LoyaltyPointBalanceFindAdapter implements LoyaltyPointBalanceFindPersistencePort {
    @Override
    public LoyaltyPointBalanceDto findLoyaltyPointBalanceById(UUID id) {
        return null;
    }

    @Override
    public List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountId(UUID accountId) {
        return null;
    }

    @Override
    public List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountIdAndLoyaltyPointId(UUID accountId, UUID loyaltyPointId) {
        return null;
    }
}
