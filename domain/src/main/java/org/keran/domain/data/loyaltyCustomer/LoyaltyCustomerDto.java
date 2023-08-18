package org.keran.domain.data.loyaltyCustomer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyCustomerDto extends AbstractEntity {
    private String customerNumber;
    private LocalDateTime registrationDate;
}
