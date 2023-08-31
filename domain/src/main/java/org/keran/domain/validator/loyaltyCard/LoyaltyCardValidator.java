package org.keran.domain.validator.loyaltyCard;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyCardValidator {
    private final Object currentClass = LoyaltyCardValidator.class;
    private final String entityName = "LoyaltyCard";
    private final LoyaltyCardFindServicePort loyaltyCardFindServicePort;

    public LoyaltyCardValidator(LoyaltyCardFindServicePort loyaltyCardFindServicePort) {
        this.loyaltyCardFindServicePort = loyaltyCardFindServicePort;
    }

    /**
     * Validates if loyalty card exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty Card ID
     */
    public void validateLoyaltyCardExists(UUID id) {
        boolean loyaltyCardExists = loyaltyCardFindServicePort.existsByLoyaltyCardId(id);

        if (!loyaltyCardExists) {
            throw new EntityNotFoundException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty card does not already exist
     * Throws {@link EntityNotFoundException} if already exists
     * @param id Loyalty Card ID
     */
    public void validateLoyaltyCardNotExists(UUID id) {
        boolean loyaltyCardExists = loyaltyCardFindServicePort.existsByLoyaltyCardId(id);

        if (loyaltyCardExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty card number does not already exist
     * Throws {@link EntityNotFoundException} if already exists
     * @param cardNumber Loyalty Card number
     */
    public void validateLoyaltyCardNotExistsByCardNumber(String cardNumber) {
        boolean loyaltyCardExists = loyaltyCardFindServicePort.existsByLoyaltyCardNumber(cardNumber);

        if (loyaltyCardExists) {
            throw new EntityAlreadyExistsException(currentClass, entityName, cardNumber);
        }
    }
}
