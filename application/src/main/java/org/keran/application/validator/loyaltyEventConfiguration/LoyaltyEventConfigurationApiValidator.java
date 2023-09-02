package org.keran.application.validator.loyaltyEventConfiguration;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;

@UtilityClass
public class LoyaltyEventConfigurationApiValidator {
    public static void validateLoyaltyEventConfigurationApiObject(LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject) {
        if (loyaltyEventConfigurationApiObject.getLoyaltyPointsToAward() == null) {
            throw new FieldIsMissingException(LoyaltyEventConfigurationApiObject.class.getSimpleName(), "loyaltyPointsToAward");
        }
    }
}
