package org.keran.domain.ports.spi.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;

import java.util.Optional;

public interface LoyaltyEventOccurrenceUpdatePersistencePort {
    Optional<LoyaltyEventOccurrenceDto> updateLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto);
}
