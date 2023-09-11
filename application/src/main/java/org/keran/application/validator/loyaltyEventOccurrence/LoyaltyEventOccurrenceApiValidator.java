package org.keran.application.validator.loyaltyEventOccurrence;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyEventOccurrenceApiValidator {
    private LoyaltyEventOccurrenceApiValidator() {}
    public static void validateLoyaltyEventOccurrenceApiObject(LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject) {
        if (loyaltyEventOccurrenceApiObject.getDateOfOccurrence() == null) {
            throw new FieldIsMissingException(LoyaltyEventOccurrenceApiObject.class.getSimpleName(), "DateOfOccurrence");
        }
        if (loyaltyEventOccurrenceApiObject.getQuantityOfOccurrence() == null) {
            throw new FieldIsMissingException(LoyaltyEventOccurrenceApiObject.class.getSimpleName(), "QuantityOfOccurrence");
        }
    }
}
