package org.keran.application.validator.loyaltyCard;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyCardApiObject;

@UtilityClass
public class LoyaltyCardApiValidator {
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
