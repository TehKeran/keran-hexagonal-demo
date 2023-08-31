package org.keran.application.validator.loyaltyCard;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyCardApiObject;

@UtilityClass
public class LoyaltyCardApiValidator {
    private static final Object currentClass = LoyaltyCardApiValidator.class;
    public static void validateLoyaltyCardApiObject(LoyaltyCardApiObject loyaltyCardApiObject) {
        if (loyaltyCardApiObject.getCardNumber() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyCardApiObject", "CardNumber");
        }
        if (loyaltyCardApiObject.getDisplayName() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyCardApiObject", "DisplayName");
        }
    }
}
