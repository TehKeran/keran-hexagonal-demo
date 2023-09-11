package org.keran.application.validator.loyaltyPointBalance;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyPointBalanceApiValidator {
    private LoyaltyPointBalanceApiValidator() {}
    public static void validateLoyaltyPointBalanceApiObject(LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject) {
        if (loyaltyPointBalanceApiObject.getBalance() == null) {
            throw new FieldIsMissingException(LoyaltyPointBalanceApiObject.class.getSimpleName(), "balance");
        }
    }
}
