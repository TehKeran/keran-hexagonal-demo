package org.keran.application.validator.loyaltyEventConfiguration;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;

@UtilityClass
public class LoyaltyEventConfigurationApiValidator {
    private static final Object currentClass = LoyaltyEventConfigurationApiValidator.class;
    public static void validateLoyaltyEventConfigurationApiObject(LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject) {
        if (loyaltyEventConfigurationApiObject.getLoyaltyPointsToAward() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyEventConfigurationApiObject", "loyaltyPointsToAward");
        }
        if (loyaltyEventConfigurationApiObject.getLoyaltyEventId() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyEventConfigurationApiObject", "LoyaltyEventId");
        }
    }
}
