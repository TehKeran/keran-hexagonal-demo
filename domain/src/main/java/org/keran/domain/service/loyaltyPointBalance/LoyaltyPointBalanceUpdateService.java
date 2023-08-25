package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceUpdatePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyPointBalanceUpdateService implements LoyaltyPointBalanceUpdateServicePort {
    private final LoyaltyPointBalanceUpdatePersistencePort loyaltyPointBalanceUpdatePersistencePort;

    public LoyaltyPointBalanceUpdateService(LoyaltyPointBalanceUpdatePersistencePort loyaltyPointBalanceUpdatePersistencePort) {
        this.loyaltyPointBalanceUpdatePersistencePort = loyaltyPointBalanceUpdatePersistencePort;
    }

    @Override
    public LoyaltyPointBalanceDto updateLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        return loyaltyPointBalanceUpdatePersistencePort.updateLoyaltyPointBalance(loyaltyPointBalanceDto);
    }
}
