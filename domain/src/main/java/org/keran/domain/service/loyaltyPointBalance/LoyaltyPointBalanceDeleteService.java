package org.keran.domain.service.loyaltyPointBalance;

import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyPointBalance.LoyaltyPointBalanceDeletePersistencePort;
import org.keran.domain.validator.loyaltyPointBalance.LoyaltyPointBalanceValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointBalanceDeleteService implements LoyaltyPointBalanceDeleteServicePort {
    private final LoyaltyPointBalanceDeletePersistencePort loyaltyPointBalanceDeletePersistencePort;
    private final LoyaltyPointBalanceValidator loyaltyPointBalanceValidator;

    public LoyaltyPointBalanceDeleteService(LoyaltyPointBalanceDeletePersistencePort loyaltyPointBalanceDeletePersistencePort, LoyaltyPointBalanceValidator loyaltyPointBalanceValidator) {
        this.loyaltyPointBalanceDeletePersistencePort = loyaltyPointBalanceDeletePersistencePort;
        this.loyaltyPointBalanceValidator = loyaltyPointBalanceValidator;
    }

    @Override
    public void deleteLoyaltyPointBalanceById(UUID id) {
        // Business validation
        // - Loyalty point balance must exist
        loyaltyPointBalanceValidator.validateLoyaltyPointBalanceExists(id);

        loyaltyPointBalanceDeletePersistencePort.deleteLoyaltyPointBalanceById(id);
    }

    @Override
    public void deleteAllLoyaltyPointBalanceByLoyaltyAccountId(UUID loyaltyAccountId) {
        loyaltyPointBalanceDeletePersistencePort.deleteAllLoyaltyPointBalanceByLoyaltyAccountId(loyaltyAccountId);
    }
}
