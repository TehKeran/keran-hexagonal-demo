package org.keran.application.validator.loyaltyEventOccurrence;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;

@UtilityClass
public class LoyaltyEventOccurrenceApiValidator {
    private static final Object currentClass = LoyaltyEventOccurrenceApiValidator.class;
    public static void validateLoyaltyEventOccurrenceApiObject(LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject) {
        if (loyaltyEventOccurrenceApiObject.getLoyaltyEventId() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyEventOccurrenceApiObject", "LoyaltyEventId");
        }
        if (loyaltyEventOccurrenceApiObject.getDateOfOccurrence() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyEventOccurrenceApiObject", "DateOfOccurrence");
        }
        if (loyaltyEventOccurrenceApiObject.getQuantityOfOccurrence() == null) {
            throw new FieldIsMissingException(currentClass, "LoyaltyEventOccurrenceApiObject", "QuantityOfOccurrence");
        }
    }
}
