package org.keran.application.controller.loyaltyEventOccurrence;

import org.keran.application.utility.loyaltyEventOccurrence.LoyaltyEventOccurrenceResponseFactory;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyEventOccurrenceDeleteController implements LoyaltyEventOccurrenceDeleteControllerApi {
    private final LoyaltyEventOccurrenceDeleteServicePort loyaltyEventOccurrenceDeleteServicePort;

    public LoyaltyEventOccurrenceDeleteController(LoyaltyEventOccurrenceDeleteServicePort loyaltyEventOccurrenceDeleteServicePort) {
        this.loyaltyEventOccurrenceDeleteServicePort = loyaltyEventOccurrenceDeleteServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventOccurrenceResponseObject> deleteLoyaltyEventOccurrenceById(@PathVariable UUID loyaltyEventOccurrenceId) {
        // Delete (with validations)
        loyaltyEventOccurrenceDeleteServicePort.deleteLoyaltyEventOccurrenceById(loyaltyEventOccurrenceId);
        // Prepare response
        return LoyaltyEventOccurrenceResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty Event Occurrence deleted with ID: %s", loyaltyEventOccurrenceId),
                new ArrayList<>());
    }
}
