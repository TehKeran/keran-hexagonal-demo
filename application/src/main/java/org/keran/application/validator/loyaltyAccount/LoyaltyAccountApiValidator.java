package org.keran.application.validator.loyaltyAccount;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;

@UtilityClass
public class LoyaltyAccountApiValidator {

    private static final Object currentClass = LoyaltyAccountApiValidator.class;
    public static void validateLoyaltyAccountApiObject(LoyaltyAccountApiObject loyaltyAccountApiObject) {
        if (loyaltyAccountApiObject.getAccountNumber() == null) {
            throw new FieldIsMissingException(currentClass, "loyaltyAccountApiObject", "AccountNumber");
        }
        if (loyaltyAccountApiObject.getLoyaltyAccountType() == null) {
            throw new FieldIsMissingException(currentClass, "loyaltyAccountApiObject", "LoyaltyAccountType");
        }
        if (loyaltyAccountApiObject.getLoyaltyProgramId() == null) {
            throw new FieldIsMissingException(currentClass, "loyaltyAccountApiObject", "LoyaltyProgramId");
        }
        if (loyaltyAccountApiObject.getStartDate() == null) {
            throw new FieldIsMissingException(currentClass, "loyaltyAccountApiObject", "StartDate");
        }
    }
}
