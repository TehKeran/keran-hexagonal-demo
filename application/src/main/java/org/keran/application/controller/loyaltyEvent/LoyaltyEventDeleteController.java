package org.keran.application.controller.loyaltyEvent;

import org.keran.application.utility.loyaltyEvent.LoyaltyEventResponseFactory;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyEventResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyEventDeleteController implements LoyaltyEventDeleteControllerApi {
    private final LoyaltyEventDeleteServicePort loyaltyEventDeleteServicePort;

    public LoyaltyEventDeleteController(LoyaltyEventDeleteServicePort loyaltyEventDeleteServicePort) {
        this.loyaltyEventDeleteServicePort = loyaltyEventDeleteServicePort;
    }

    @Transactional
    @Override
    public ResponseEntity<LoyaltyEventResponseObject> deleteLoyaltyEventById(@PathVariable UUID loyaltyEventId) {
        // Delete loyalty Event (with validations)
        loyaltyEventDeleteServicePort.deleteLoyaltyEventById(loyaltyEventId);

        // Prepare response
        return LoyaltyEventResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty Event deleted with ID: %s", loyaltyEventId),
                new ArrayList<>());
    }
}
