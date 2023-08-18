package org.keran.domain.ports.api.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;

public interface LoyaltyEventOccurrenceAddServicePort {
    LoyaltyEventOccurrenceDto addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
}
