package org.keran.application.validator.loyaltyEventConfiguration;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyEventConfigurationApiValidator {
    private LoyaltyEventConfigurationApiValidator() {}
    public static void validateLoyaltyEventConfigurationApiObject(LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject) {
        if (loyaltyEventConfigurationApiObject.getLoyaltyPointsToAward() == null) {
            throw new FieldIsMissingException(LoyaltyEventConfigurationApiObject.class.getSimpleName(), "loyaltyPointsToAward");
        }
    }
}
