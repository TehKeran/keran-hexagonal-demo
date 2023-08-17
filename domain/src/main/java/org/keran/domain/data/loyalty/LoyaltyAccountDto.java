package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventOccurrenceBalanceDto;
import org.keran.domain.definition.LoyaltyAccountType;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyAccountDto extends AbstractEntity {
    private String accountNumber;
    private String externalAccountNumber;
    private LoyaltyAccountType accountType;
    private Date startDate;
    private Date closeDate;
    private List<LoyaltyPointBalanceDto> pointBalanceDtoList;
    private List<LoyaltyEventOccurrenceBalanceDto> loyaltyEventOccurrenceBalanceDtoList;

}
