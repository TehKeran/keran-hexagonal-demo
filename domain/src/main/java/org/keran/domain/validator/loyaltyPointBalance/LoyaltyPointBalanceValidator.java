package org.keran.domain.validator.loyaltyPointBalance;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyPointBalanceValidator {
    private final String entityName = "LoyaltyPointBalanceBalance";
    private final LoyaltyPointBalanceFindServicePort loyaltyPointBalanceFindServicePort;

    public LoyaltyPointBalanceValidator(LoyaltyPointBalanceFindServicePort loyaltyPointBalanceFindServicePort) {
        this.loyaltyPointBalanceFindServicePort = loyaltyPointBalanceFindServicePort;
    }

    /**
     * Validates if loyalty point balance exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty point balance ID
     */
    public void validateLoyaltyPointBalanceExists(UUID id) {
        boolean LoyaltyPointBalanceExists = loyaltyPointBalanceFindServicePort.existsById(id);

        if (!LoyaltyPointBalanceExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty point balance doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id Loyalty point balance ID
     */
    public void validateLoyaltyPointBalanceNotExists(UUID id) {
        boolean LoyaltyPointBalanceExists = loyaltyPointBalanceFindServicePort.existsById(id);

        if (LoyaltyPointBalanceExists) {
            throw new EntityAlreadyExistsException(entityName, id.toString());
        }
    }
}
