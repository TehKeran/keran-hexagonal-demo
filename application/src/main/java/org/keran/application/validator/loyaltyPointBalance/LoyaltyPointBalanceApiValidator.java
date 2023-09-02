package org.keran.application.validator.loyaltyPointBalance;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;

@UtilityClass
public class LoyaltyPointBalanceApiValidator {
    public static void validateLoyaltyPointBalanceApiObject(LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject) {
        if (loyaltyPointBalanceApiObject.getBalance() == null) {
            throw new FieldIsMissingException(LoyaltyPointBalanceApiObject.class.getSimpleName(), "balance");
        }
    }
}
