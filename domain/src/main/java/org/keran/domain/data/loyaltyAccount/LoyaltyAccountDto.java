package org.keran.domain.data.loyaltyAccount;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyAccountDto extends AbstractEntity {
    private LoyaltyCustomerDto loyaltyCustomerDto;
    private LoyaltyProgramDto loyaltyProgramDto;
    private LoyaltyAccountTypeEnum loyaltyAccountType;
    private String accountNumber;
    private String externalAccountNumber;
    private LocalDateTime startDate;
    private LocalDateTime closeDate;

}
