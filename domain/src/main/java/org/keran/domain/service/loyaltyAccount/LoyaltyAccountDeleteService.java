package org.keran.domain.service.loyaltyAccount;

import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountDeleteServicePort;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceDeleteServicePort;
import org.keran.domain.ports.spi.loyaltyAccount.LoyaltyAccountDeletePersistencePort;
import org.keran.domain.validator.loyaltyAccount.LoyaltyAccountValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyAccountDeleteService implements LoyaltyAccountDeleteServicePort {
    private final LoyaltyAccountDeletePersistencePort loyaltyAccountDeletePersistencePort;
    private final LoyaltyAccountValidator loyaltyAccountValidator;


    public LoyaltyAccountDeleteService(LoyaltyAccountDeletePersistencePort loyaltyAccountDeletePersistencePort,
                                       LoyaltyAccountValidator loyaltyAccountValidator) {
        this.loyaltyAccountDeletePersistencePort = loyaltyAccountDeletePersistencePort;
        this.loyaltyAccountValidator = loyaltyAccountValidator;
    }

    @Override
    public void deleteLoyaltyAccountById(UUID id) {
        // Business validation
        // - Account exists
        loyaltyAccountValidator.validateLoyaltyAccountExists(id);

        loyaltyAccountDeletePersistencePort.deleteLoyaltyAccountById(id);
    }

    @Override
    public void deleteLoyaltyAccountTransactionHistoryById(UUID id) {
        loyaltyAccountDeletePersistencePort.deleteLoyaltyAccountTransactionHistoryById(id);
    }

    @Override
    public void deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccount_Id(UUID loyaltyAccountId) {
        loyaltyAccountDeletePersistencePort.deleteAllLoyaltyAccountTransactionHistoryByLoyaltyAccount_Id(loyaltyAccountId);
    }
}
