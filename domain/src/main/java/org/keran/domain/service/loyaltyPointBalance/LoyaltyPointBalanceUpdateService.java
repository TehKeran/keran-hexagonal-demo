package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceUpdateServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceUpdatePersistencePort;
import org.keran.domain.validator.loyaltyPointBalance.LoyaltyPointBalanceValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointBalanceUpdateService implements LoyaltyPointBalanceUpdateServicePort {
    private final LoyaltyPointBalanceUpdatePersistencePort loyaltyPointBalanceUpdatePersistencePort;
    private final LoyaltyPointBalanceValidator loyaltyPointBalanceValidator;

    public LoyaltyPointBalanceUpdateService(LoyaltyPointBalanceUpdatePersistencePort loyaltyPointBalanceUpdatePersistencePort, LoyaltyPointBalanceValidator loyaltyPointBalanceValidator) {
        this.loyaltyPointBalanceUpdatePersistencePort = loyaltyPointBalanceUpdatePersistencePort;
        this.loyaltyPointBalanceValidator = loyaltyPointBalanceValidator;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> updateLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        // Business validation
        // - Loyalty point balance must exist
        loyaltyPointBalanceValidator.validateLoyaltyPointBalanceExists(loyaltyPointBalanceDto.getId());

        return loyaltyPointBalanceUpdatePersistencePort.updateLoyaltyPointBalance(loyaltyPointBalanceDto);
    }
}
