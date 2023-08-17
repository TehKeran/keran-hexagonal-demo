package org.keran.domain.data.loyaltyEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyEventOccurrenceBalanceDto extends AbstractEntity {
    private LoyaltyEventDto loyaltyEventDto;
    private Date dateOfOccurrence;
    private int quantityOfOccurrence;
}
