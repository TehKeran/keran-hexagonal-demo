package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.customer.CustomerDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyAccountDto extends AbstractEntity {
    private CustomerDto customerDto;
    private LoyaltyProgramDto loyaltyProgramDto;
    private String accountNumber;
    private String externalAccountNumber;
    private LoyaltyAccountTypeEnum accountType;
    private LocalDateTime startDate;
    private LocalDateTime closeDate;

}
