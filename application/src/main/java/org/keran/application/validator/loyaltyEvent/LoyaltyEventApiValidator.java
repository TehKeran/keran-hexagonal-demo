package org.keran.application.validator.loyaltyEvent;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventApiObject;

@UtilityClass
public class LoyaltyEventApiValidator {
    public static void validateLoyaltyEventApiObject(LoyaltyEventApiObject loyaltyEventApiObject) {
        if (loyaltyEventApiObject.getName() == null) {
            throw new FieldIsMissingException(LoyaltyEventApiObject.class.getSimpleName(), "name");
        }
    }
}
