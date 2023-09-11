package org.keran.application.validator.loyaltyPoint;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyPointApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyPointApiValidator {
    private LoyaltyPointApiValidator() {}
    public static void validateLoyaltyPointApiObject(LoyaltyPointApiObject loyaltyPointApiObject) {
        if (loyaltyPointApiObject.getName() == null) {
            throw new FieldIsMissingException(LoyaltyPointApiObject.class.getSimpleName(), "name");
        }
    }
}
