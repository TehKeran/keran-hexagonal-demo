package org.keran.domain.ports.api.loyaltyCustomer;

import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

public interface LoyaltyCustomerAddServicePort {
    LoyaltyCustomerDto addLoyaltyCustomer(LoyaltyCustomerDto loyaltyCustomerDto);

}
