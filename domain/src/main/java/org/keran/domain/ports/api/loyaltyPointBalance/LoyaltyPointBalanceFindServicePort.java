package org.keran.domain.ports.api.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;

import java.util.List;
import java.util.UUID;

public interface LoyaltyPointBalanceFindServicePort {
    LoyaltyPointBalanceDto findLoyaltyPointBalanceById(UUID id);
    List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountId(UUID accountId);
    List<LoyaltyPointBalanceDto> findLoyaltyPointBalancesByAccountIdAndLoyaltyPointId(UUID accountId, UUID loyaltyPointId);
}
