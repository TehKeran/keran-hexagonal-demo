package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyPointBalanceDto extends AbstractEntity {
    private LoyaltyPointDto loyaltyPointDto;
    private String name;
    private int balance;
}
