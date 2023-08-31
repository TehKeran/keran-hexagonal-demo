package org.keran.application.controller.loyaltyPointBalance;

import org.keran.application.utility.loyaltyPointBalance.LoyaltyPointBalanceResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyPointBalanceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyPointBalanceDeleteController implements LoyaltyPointBalanceDeleteControllerApi {
    private final LoyaltyPointBalanceDeleteServicePort loyaltyPointBalanceDeleteServicePort;

    public LoyaltyPointBalanceDeleteController(LoyaltyPointBalanceDeleteServicePort loyaltyPointBalanceDeleteServicePort) {
        this.loyaltyPointBalanceDeleteServicePort = loyaltyPointBalanceDeleteServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointBalanceResponseObject> deleteLoyaltyPointBalanceById(UUID loyaltyPointBalanceId) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyPointBalanceId, "loyaltyPointBalance", "loyaltyPointBalanceId");

        // Delete (with validations)
        loyaltyPointBalanceDeleteServicePort.deleteLoyaltyPointBalanceById(loyaltyPointBalanceId);

        // Prepare response
        return LoyaltyPointBalanceResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty Point balance deleted with ID: %s", loyaltyPointBalanceId),
                new ArrayList<>());
    }
}
