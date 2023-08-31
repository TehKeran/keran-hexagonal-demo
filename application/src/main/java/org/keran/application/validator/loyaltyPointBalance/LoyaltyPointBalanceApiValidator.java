package org.keran.application.validator.loyaltyPointBalance;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;

@UtilityClass
public class LoyaltyPointBalanceApiValidator {
    private static final Object currentClass = LoyaltyPointBalanceApiValidator.class;
    public static void validateLoyaltyPointBalanceApiObject(LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject) {
        if (loyaltyPointBalanceApiObject.getBalance() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyPointBalanceApiObject", "balance");
        }
        if (loyaltyPointBalanceApiObject.getLoyaltyPointId() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyPointBalanceApiObject", "loyaltyPointId");
        }
    }
}
