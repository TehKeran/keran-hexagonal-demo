package org.keran.domain.data.loyaltyPointBalance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyPointBalanceDto extends AbstractEntity {
    private LoyaltyAccountDto loyaltyAccountDto;
    private LoyaltyPointDto loyaltyPointDto;
    private int balance;
}
