package org.keran.domain.data.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConsentDto extends AbstractEntity {
    private LoyaltyCustomerDto loyaltyCustomerDto;
    private String consentName;
    private Boolean isGranted;
}
