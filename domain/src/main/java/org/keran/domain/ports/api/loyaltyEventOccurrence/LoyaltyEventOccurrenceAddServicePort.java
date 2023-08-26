package org.keran.domain.ports.api.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;

import java.util.Optional;

public interface LoyaltyEventOccurrenceAddServicePort {
    Optional<LoyaltyEventOccurrenceDto> addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
}
