package org.keran.domain.data.loyaltyEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyEventConfigurationDto extends AbstractEntity {

    private LoyaltyProgramDto loyaltyProgramDto;
    private LoyaltyEventDto loyaltyEventDto;
    private int loyaltyPointsToAward;
}
