package org.keran.application.validator.loyaltyProgram;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;

@UtilityClass
public class LoyaltyProgramApiValidator {
    private static final Object currentClass = LoyaltyProgramApiValidator.class;
    public static void validateLoyaltyProgramApiObject(LoyaltyProgramApiObject loyaltyProgramApiObject) {
        if (loyaltyProgramApiObject.getName() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyProgramApiObject", "Name");
        }
        if (loyaltyProgramApiObject.getStartDate() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyProgramApiObject", "StartDate");
        }
    }
}
