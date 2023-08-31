package org.keran.application.validator.loyaltyPoint;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyPointApiObject;

@UtilityClass
public class LoyaltyPointApiValidator {
    private static final Object currentClass = LoyaltyPointApiValidator.class;
    public static void validateLoyaltyPointApiObject(LoyaltyPointApiObject loyaltyPointApiObject) {
        if (loyaltyPointApiObject.getName() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyPointApiObject", "name");
        }
    }
}
