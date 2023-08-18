package org.keran.domain.ports.api.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;

public interface LoyaltyEventOccurrenceUpdateServicePort {
    LoyaltyEventOccurrenceDto updateLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
}
