package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceAddServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointBalanceAddService implements LoyaltyPointBalanceAddServicePort {
    private final LoyaltyPointBalanceAddPersistencePort loyaltyPointBalanceAddPersistencePort;

    public LoyaltyPointBalanceAddService(LoyaltyPointBalanceAddPersistencePort loyaltyPointBalanceAddPersistencePort) {
        this.loyaltyPointBalanceAddPersistencePort = loyaltyPointBalanceAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        return loyaltyPointBalanceAddPersistencePort.addLoyaltyPointBalance(loyaltyPointBalanceDto);
    }
}
