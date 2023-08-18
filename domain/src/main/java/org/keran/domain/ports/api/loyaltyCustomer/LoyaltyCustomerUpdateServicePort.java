package org.keran.domain.ports.api.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

public interface LoyaltyCustomerUpdateServicePort {
    LoyaltyCustomerDto updateLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto);
}
