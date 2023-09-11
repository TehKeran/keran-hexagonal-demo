package org.keran.application.validator.loyaltyCustomer;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyCustomerApiValidator {
    private LoyaltyCustomerApiValidator() {}
    public static void validateLoyaltyCustomerApiObject(LoyaltyCustomerApiObject loyaltyCustomerApiObject) {
        if (loyaltyCustomerApiObject.getCustomerNumber() == null) {
            throw new FieldIsMissingException(LoyaltyCustomerApiObject.class.getSimpleName(), "CustomerNumber");
        }
    }
}
