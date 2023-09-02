package org.keran.application.controller.loyaltyProgram;

import org.keran.application.utility.loyaltyProgram.LoyaltyProgramResponseFactory;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyProgramResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyProgramDeleteController implements LoyaltyProgramDeleteControllerApi {
    private final LoyaltyProgramDeleteServicePort loyaltyProgramDeleteServicePort;

    public LoyaltyProgramDeleteController(LoyaltyProgramDeleteServicePort loyaltyProgramDeleteServicePort) {
        this.loyaltyProgramDeleteServicePort = loyaltyProgramDeleteServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyProgramResponseObject> deleteLoyaltyProgramById(@PathVariable UUID loyaltyProgramId) {
        // Delete loyalty program (with validations)
        loyaltyProgramDeleteServicePort.deleteLoyaltyProgramById(loyaltyProgramId);

        // Prepare response
        return LoyaltyProgramResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty Program deleted with ID: %s and all connected entities", loyaltyProgramId),
                new ArrayList<>());
    }
}

