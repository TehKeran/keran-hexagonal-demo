package org.keran.application.validator.loyaltyEvent;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyEventApiValidator {
    private LoyaltyEventApiValidator() {}
    public static void validateLoyaltyEventApiObject(LoyaltyEventApiObject loyaltyEventApiObject) {
        if (loyaltyEventApiObject.getName() == null) {
            throw new FieldIsMissingException(LoyaltyEventApiObject.class.getSimpleName(), "name");
        }
    }
}
