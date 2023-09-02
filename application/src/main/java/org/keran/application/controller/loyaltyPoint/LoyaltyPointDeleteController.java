package org.keran.application.controller.loyaltyPoint;

import org.keran.application.utility.loyaltyPoint.LoyaltyPointResponseFactory;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyPointResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyPointDeleteController implements LoyaltyPointDeleteControllerApi {
    private final LoyaltyPointDeleteServicePort loyaltyPointDeleteServicePort;

    public LoyaltyPointDeleteController(LoyaltyPointDeleteServicePort loyaltyPointDeleteServicePort) {
        this.loyaltyPointDeleteServicePort = loyaltyPointDeleteServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointResponseObject> deleteLoyaltyPointById(@PathVariable UUID loyaltyPointId) {
        // Delete (with validations)
        loyaltyPointDeleteServicePort.deleteLoyaltyPointById(loyaltyPointId);

        // Prepare response
        return LoyaltyPointResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty Point deleted with ID: %s", loyaltyPointId),
                new ArrayList<>());
    }
}
