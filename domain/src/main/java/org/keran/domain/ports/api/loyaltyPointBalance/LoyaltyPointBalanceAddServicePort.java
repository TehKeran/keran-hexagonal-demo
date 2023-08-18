package org.keran.domain.ports.api.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;

public interface LoyaltyPointBalanceAddServicePort {
    LoyaltyPointBalanceDto addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
}
