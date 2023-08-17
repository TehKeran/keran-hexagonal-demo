package org.keran.domain.data.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyalty.LoyaltyAccountDto;
import org.keran.domain.data.loyalty.LoyaltyCardDto;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDto extends AbstractEntity {
    private Date registrationDate;
    private List<ConsentDto> consentDtoList;
    private List<LoyaltyAccountDto> loyaltyAccountDtoList;
    private List<LoyaltyCardDto> loyaltyCardDtoList;
}
