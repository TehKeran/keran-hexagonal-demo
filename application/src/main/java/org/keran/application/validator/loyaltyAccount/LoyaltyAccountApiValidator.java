package org.keran.application.validator.loyaltyAccount;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyAccountApiValidator {
    private LoyaltyAccountApiValidator() {}
    public static void validateLoyaltyAccountApiObject(LoyaltyAccountApiObject loyaltyAccountApiObject) {
        if (loyaltyAccountApiObject.getAccountNumber() == null) {
            throw new FieldIsMissingException(LoyaltyAccountApiObject.class.getSimpleName(), "AccountNumber");
        }
        if (loyaltyAccountApiObject.getLoyaltyAccountType() == null) {
            throw new FieldIsMissingException(LoyaltyAccountApiObject.class.getSimpleName(), "LoyaltyAccountType");
        }
        if (loyaltyAccountApiObject.getStartDate() == null) {
            throw new FieldIsMissingException(LoyaltyAccountApiObject.class.getSimpleName(), "StartDate");
        }
    }
}
