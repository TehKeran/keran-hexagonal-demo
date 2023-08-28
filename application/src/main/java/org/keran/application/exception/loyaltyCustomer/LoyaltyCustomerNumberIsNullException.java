package org.keran.application.exception.loyaltyCustomer;

import org.springframework.util.StringUtils;

public class LoyaltyCustomerNumberIsNullException extends RuntimeException {
    public LoyaltyCustomerNumberIsNullException(Object throwable) {
        super(LoyaltyCustomerNumberIsNullException.generateMessage(throwable.toString()));
    }

    private static String generateMessage(String callingClass) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length - 1];
        return String.format("%s: CustomerNumber field is null, it is mandatory",
                StringUtils.capitalize(callingClassSimpleName));
    }
}
