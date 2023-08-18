package org.keran.domain.ports.spi.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;

public interface LoyaltyEventOccurrenceAddPersistencePort {
    LoyaltyEventOccurrenceDto addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
}
