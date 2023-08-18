package org.keran.domain.data.loyaltyPoint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyPointDto extends AbstractEntity {
    private String name;
    private String imageUrl;
}
