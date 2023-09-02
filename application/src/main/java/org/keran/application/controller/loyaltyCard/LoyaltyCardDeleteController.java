package org.keran.application.controller.loyaltyCard;

import org.keran.application.utility.loyaltyCard.LoyaltyCardResponseFactory;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyCardResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyCardDeleteController implements LoyaltyCardDeleteControllerApi {
    private final LoyaltyCardDeleteServicePort loyaltyCardDeleteServicePort;

    public LoyaltyCardDeleteController(LoyaltyCardDeleteServicePort loyaltyCardDeleteServicePort) {
        this.loyaltyCardDeleteServicePort = loyaltyCardDeleteServicePort;
    }

    @Override
    @Transactional
    public ResponseEntity<LoyaltyCardResponseObject> deleteLoyaltyCardById(@PathVariable UUID loyaltyCardId) {
        // Delete (with validation)
        loyaltyCardDeleteServicePort.deleteLoyaltyCardById(loyaltyCardId);
        // Prepare response
        LoyaltyCardResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty card deleted with ID: %s", loyaltyCardId), new ArrayList<>());

        return LoyaltyCardDeleteControllerApi.super.deleteLoyaltyCardById(loyaltyCardId);
    }
}
