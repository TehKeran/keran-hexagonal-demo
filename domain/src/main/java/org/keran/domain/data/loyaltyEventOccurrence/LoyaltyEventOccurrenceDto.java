package org.keran.domain.data.loyaltyEventOccurrence;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyEventOccurrenceDto extends AbstractEntity {
    private LoyaltyCustomerDto loyaltyCustomerDto;
    private LoyaltyEventDto loyaltyEventDto;
    private LocalDateTime dateOfOccurrence;
    private int quantityOfOccurrence;
    private String source;
}
