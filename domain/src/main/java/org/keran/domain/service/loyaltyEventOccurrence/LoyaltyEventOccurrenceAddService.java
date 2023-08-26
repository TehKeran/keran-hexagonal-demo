package org.keran.domain.service.loyaltyEventOccurrence;

import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddServicePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyEventOccurrenceAddService implements LoyaltyEventOccurrenceAddServicePort {
    private final LoyaltyEventOccurrenceAddService loyaltyEventOccurrenceAddService;

    public LoyaltyEventOccurrenceAddService(LoyaltyEventOccurrenceAddService loyaltyEventOccurrenceAddService) {
        this.loyaltyEventOccurrenceAddService = loyaltyEventOccurrenceAddService;
    }

    @Override
    public Optional<LoyaltyEventOccurrenceDto> addLoyaltyEventOccurrence(LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto) {
        return loyaltyEventOccurrenceAddService.addLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);
    }
}
