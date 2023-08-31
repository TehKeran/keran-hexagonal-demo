package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceAddServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceAddPersistencePort;
import org.keran.domain.validator.loyaltyAccount.LoyaltyAccountValidator;
import org.keran.domain.validator.loyaltyPoint.LoyaltyPointValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyPointBalanceAddService implements LoyaltyPointBalanceAddServicePort {
    private final LoyaltyPointBalanceAddPersistencePort loyaltyPointBalanceAddPersistencePort;
    private final LoyaltyPointValidator loyaltyPointValidator;
    private final LoyaltyAccountValidator loyaltyAccountValidator;

    public LoyaltyPointBalanceAddService(LoyaltyPointBalanceAddPersistencePort loyaltyPointBalanceAddPersistencePort, LoyaltyPointValidator loyaltyPointValidator, LoyaltyAccountValidator loyaltyAccountValidator) {
        this.loyaltyPointBalanceAddPersistencePort = loyaltyPointBalanceAddPersistencePort;
        this.loyaltyPointValidator = loyaltyPointValidator;
        this.loyaltyAccountValidator = loyaltyAccountValidator;
    }

    @Override
    public Optional<LoyaltyPointBalanceDto> addLoyaltyPointBalance(LoyaltyPointBalanceDto loyaltyPointBalanceDto) {
        // Business validation
        // - If ID is provided, it must not exist
        if (loyaltyPointBalanceDto.getId() != null) {
            loyaltyPointValidator.validateLoyaltyPointNotExists(loyaltyPointBalanceDto.getId());
        }
        // - Loyalty account must exist
        loyaltyAccountValidator.validateLoyaltyAccountExists(loyaltyPointBalanceDto.getLoyaltyAccountDto().getId());
        // - Loyalty point must exist
        loyaltyPointValidator.validateLoyaltyPointExists(loyaltyPointBalanceDto.getLoyaltyPointDto().getId());

        return loyaltyPointBalanceAddPersistencePort.addLoyaltyPointBalance(loyaltyPointBalanceDto);
    }
}
