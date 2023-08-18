package org.keran.domain.data.loyaltyCard;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.definition.LoyaltyCardTypeEnum;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyCardDto  extends AbstractEntity {
    private LoyaltyCustomerDto loyaltyCustomerDto;
    private String cardNumber;
    private String displayName;
    private String cardImageUrl;
    private LoyaltyCardTypeEnum cardType;

}
