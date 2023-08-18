package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.customer.CustomerDto;
import org.keran.domain.definition.LoyaltyCardTypeEnum;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyCardDto  extends AbstractEntity {
    private CustomerDto customerDto;
    private String cardNumber;
    private String displayName;
    private String cardImageUrl;
    private LoyaltyCardTypeEnum cardType;

}
