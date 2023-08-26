package org.keran.domain.ports.api.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;

import java.util.Optional;

public interface LoyaltyPointBalanceUpdateServicePort {
    Optional<LoyaltyPointBalanceDto> updateLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
}
