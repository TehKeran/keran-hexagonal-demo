package org.keran.domain.exception.loyaltyCustomer;

import org.springframework.util.StringUtils;

public class LoyaltyCustomerNumberAlreadyExistsException extends RuntimeException {
    public LoyaltyCustomerNumberAlreadyExistsException(Object throwable, String customerNumber) {
        super(LoyaltyCustomerNumberAlreadyExistsException.generateMessage(throwable.toString(), customerNumber));
    }

    private static String generateMessage(String callingClass, String customerNumber) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length - 1];
        return String.format("%s: the entity LoyaltyCustomer with customer number: %s already exists in the database",
                StringUtils.capitalize(callingClassSimpleName),
                customerNumber);
    }
}
