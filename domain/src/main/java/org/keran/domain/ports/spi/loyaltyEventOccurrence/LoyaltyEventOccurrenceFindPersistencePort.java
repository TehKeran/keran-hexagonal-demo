package org.keran.domain.ports.spi.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoyaltyEventOccurrenceFindPersistencePort {
    Optional<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrenceById(UUID id);
    List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByAccountId(UUID accountId);
    List<LoyaltyEventOccurrenceDto> findLoyaltyEventOccurrencesByEventId(UUID eventId);
}
