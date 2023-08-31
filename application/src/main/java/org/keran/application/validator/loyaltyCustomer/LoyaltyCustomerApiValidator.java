package org.keran.application.validator.loyaltyCustomer;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.application.exception.loyaltyCustomer.LoyaltyCustomerNumberIsNullException;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;

@UtilityClass
public class LoyaltyCustomerApiValidator {
    private static final Object currentClass = LoyaltyCustomerApiValidator.class;
    public static void validateLoyaltyCustomerApiObject(LoyaltyCustomerApiObject loyaltyCustomerApiObject) {
        if (loyaltyCustomerApiObject.getCustomerNumber() == null) {
            throw new FieldIsMissingException(currentClass, "loyaltyCustomerApiObject", "CustomerNumber");
        }
    }
}
