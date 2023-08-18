package org.keran.domain.ports.spi.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;

public interface LoyaltyPointBalanceUpdatePersistencePort {
    LoyaltyPointBalanceDto updateLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
}
