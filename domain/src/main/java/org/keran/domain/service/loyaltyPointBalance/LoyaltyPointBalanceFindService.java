package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceFindServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoyaltyPointBalanceFindService implements LoyaltyPointBalanceFindServicePort {
    private final LoyaltyPointBalanceFindPersistencePort loyaltyPointBalanceFindPersistencePort;

    public LoyaltyPointBalanceFindService(LoyaltyPointBalanceFindPersistencePort loyaltyPointBalanceFindPersistencePort) {
        this.loyaltyPointBalanceFindPersistencePort = loyaltyPointBalanceFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> findLoyaltyPointBalanceById(UUID id) {
        return loyaltyPointBalanceFindPersistencePort.findLoyaltyPointBalanceById(id);
    }

    @Override
    public List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountId(UUID accountId) {
        return loyaltyPointBalanceFindPersistencePort.findLoyaltyPointBalancesByAccountId(accountId);
    }

    @Override
    public List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountIdAndLoyaltyPointId(UUID accountId, UUID loyaltyPointId) {
        return loyaltyPointBalanceFindPersistencePort.findLoyaltyPointBalancesByAccountIdAndLoyaltyPointId(accountId, loyaltyPointId);
    }

    @Override
    public boolean existsById(UUID id) {
        return loyaltyPointBalanceFindPersistencePort.existsById(id);
    }
}
