package org.keran.application.validator.loyaltyCard;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyCardApiValidator {
    private LoyaltyCardApiValidator() {}
    public static void validateLoyaltyCardApiObject(LoyaltyCardApiObject loyaltyCardApiObject) {
        if (loyaltyCardApiObject.getCardNumber() == null) {
            throw new FieldIsMissingException(LoyaltyCardApiObject.class.getSimpleName(), "CardNumber");
        }
        if (loyaltyCardApiObject.getDisplayName() == null) {
            throw new FieldIsMissingException(LoyaltyCardApiObject.class.getSimpleName(), "DisplayName");
        }
        if (loyaltyCardApiObject.getCardType() == null) {
            throw new FieldIsMissingException(LoyaltyCardApiObject.class.getSimpleName(), "CardType");
        }
    }
}
