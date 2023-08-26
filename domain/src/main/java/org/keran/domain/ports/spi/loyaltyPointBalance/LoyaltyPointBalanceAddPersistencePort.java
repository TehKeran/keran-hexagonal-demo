package org.keran.domain.ports.spi.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;

import java.util.Optional;

public interface LoyaltyPointBalanceAddPersistencePort {
    Optional<LoyaltyPointBalanceDto> addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto);
}
