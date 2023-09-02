package org.keran.application.validator.loyaltyPoint;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyPointApiObject;

@UtilityClass
public class LoyaltyPointApiValidator {
    public static void validateLoyaltyPointApiObject(LoyaltyPointApiObject loyaltyPointApiObject) {
        if (loyaltyPointApiObject.getName() == null) {
            throw new FieldIsMissingException(LoyaltyPointApiObject.class.getSimpleName(), "name");
        }
    }
}
