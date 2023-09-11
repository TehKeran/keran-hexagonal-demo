package org.keran.application.validator.loyaltyProgram;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramApiValidator {
    private LoyaltyProgramApiValidator() {}
    public static void validateLoyaltyProgramApiObject(LoyaltyProgramApiObject loyaltyProgramApiObject) {
        if (loyaltyProgramApiObject.getName() == null) {
            throw new FieldIsMissingException(LoyaltyProgramApiObject.class.getSimpleName(), "Name");
        }
        if (loyaltyProgramApiObject.getStartDate() == null) {
            throw new FieldIsMissingException(LoyaltyProgramApiObject.class.getSimpleName(), "StartDate");
        }
    }
}
