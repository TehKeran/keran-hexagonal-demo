package org.keran.domain.exception.loyaltyCustomer;


public class LoyaltyCustomerNumberAlreadyExistsException extends RuntimeException {
    public LoyaltyCustomerNumberAlreadyExistsException(String customerNumber) {
        super(LoyaltyCustomerNumberAlreadyExistsException.generateMessage(customerNumber));
    }

    private static String generateMessage(String customerNumber) {
        return String.format("Entity LoyaltyCustomer with customer number: %s already exists!",
                customerNumber);
    }
}
