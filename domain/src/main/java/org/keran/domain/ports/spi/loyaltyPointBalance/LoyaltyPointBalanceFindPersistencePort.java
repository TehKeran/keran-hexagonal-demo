package org.keran.domain.ports.spi.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyPointBalanceFindPersistencePort {
    Optional<LoyaltyPointBalanceDto> findLoyaltyPointBalanceById(UUID id);
    List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountId(UUID accountId);
    List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountIdAndLoyaltyPointId(UUID accountId, UUID loyaltyPointId);
    boolean existsById(UUID id);
}
