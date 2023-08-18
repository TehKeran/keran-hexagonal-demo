package org.keran.domain.ports.api.loyaltyEventOccurrence;

import java.util.UUID;

public interface LoyaltyEventOccurrenceDeleteServicePort {
    void deleteLoyaltyEventOccurrenceById(UUID id);
}
