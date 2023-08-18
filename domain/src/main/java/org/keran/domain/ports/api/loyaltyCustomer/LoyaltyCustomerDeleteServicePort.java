package org.keran.domain.ports.api.loyaltyCustomer;

import java.util.UUID;

public interface LoyaltyCustomerDeleteServicePort {
    void deleteLoyaltyCustomerById(UUID id);
    void deleteLoyaltyCustomerByCustomerNumber(String customerNumber);
}
