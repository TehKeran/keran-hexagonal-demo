package org.keran.application.validator.loyaltyEvent;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventApiObject;

@UtilityClass
public class LoyaltyEventApiValidator {
    private static final Object currentClass = LoyaltyEventApiValidator.class;
    public static void validateLoyaltyEventApiObject(LoyaltyEventApiObject loyaltyEventApiObject) {
        if (loyaltyEventApiObject.getName() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyEventApiObject", "name");
        }
    }
}
