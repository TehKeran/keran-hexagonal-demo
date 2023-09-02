package org.keran.application.validator.loyaltyEventOccurrence;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;

@UtilityClass
public class LoyaltyEventOccurrenceApiValidator {
    public static void validateLoyaltyEventOccurrenceApiObject(LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject) {
        if (loyaltyEventOccurrenceApiObject.getDateOfOccurrence() == null) {
            throw new FieldIsMissingException(LoyaltyEventOccurrenceApiObject.class.getSimpleName(), "DateOfOccurrence");
        }
        if (loyaltyEventOccurrenceApiObject.getQuantityOfOccurrence() == null) {
            throw new FieldIsMissingException(LoyaltyEventOccurrenceApiObject.class.getSimpleName(), "QuantityOfOccurrence");
        }
    }
}
