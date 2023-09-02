package org.keran.domain.validator.loyaltyAccount;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyAccountValidator {
    private final String entityName = "LoyaltyAccount";
    private final LoyaltyAccountFindServicePort loyaltyAccountFindServicePort;

    public LoyaltyAccountValidator(LoyaltyAccountFindServicePort loyaltyAccountFindServicePort) {
        this.loyaltyAccountFindServicePort = loyaltyAccountFindServicePort;
    }

    /**
     * Validates if loyalty account exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty account ID
     */
    public void validateLoyaltyAccountExists(UUID id) {
        boolean loyaltyAccountExists = loyaltyAccountFindServicePort.existsLoyaltyAccountById(id);

        if (!loyaltyAccountExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }


    /**
     * Validates if loyalty account does not already exist
     * Throws {@link EntityNotFoundException} if already exists
     * @param id Loyalty account ID
     */
    public void validateLoyaltyAccountNotExists(UUID id) {
        boolean loyaltyAccountExists = loyaltyAccountFindServicePort.existsLoyaltyAccountById(id);

        if (loyaltyAccountExists) {
            throw new EntityAlreadyExistsException(entityName, id.toString());
        }
    }


    /**
     * Validates if loyalty account exists by account number
     * Throws {@link EntityNotFoundException} if not exists
     * @param accountNumber Loyalty account number
     */
    public void validateLoyaltyAccountNotExistsByAccountNumber(String accountNumber) {
        boolean loyaltyAccountExists = loyaltyAccountFindServicePort.existsLoyaltyAccountByAccountNumber(accountNumber);

        if (loyaltyAccountExists) {
            throw new EntityAlreadyExistsException(entityName, accountNumber);
        }
    }
}
