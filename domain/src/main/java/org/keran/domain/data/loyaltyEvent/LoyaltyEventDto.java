package org.keran.domain.data.loyaltyEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyEventDto extends AbstractEntity {
    private String name;
}
