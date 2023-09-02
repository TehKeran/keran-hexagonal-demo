package org.keran.application.exception.loyaltyCustomer;

public class LoyaltyCustomerNumberIsNullException extends RuntimeException {
    public LoyaltyCustomerNumberIsNullException() {
        super("CustomerNumber field is null, it is mandatory");
    }
}
