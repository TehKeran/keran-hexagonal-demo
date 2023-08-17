package org.keran.domain.data.loyalty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.keran.domain.data.AbstractEntity;
import org.keran.domain.definition.LoyaltyCardType;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoyaltyCardDto  extends AbstractEntity {
    private String cardNumber;
    private String displayNameOnCard;
    private String cardImageUrl;
    private LoyaltyCardType cardType;

}
