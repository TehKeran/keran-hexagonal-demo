package org.keran.application.controller.loyaltyEventConfiguration;

import org.keran.application.utility.loyaltyEventConfiguration.LoyaltyEventConfigurationResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyEventConfigurationResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyEventConfigurationDeleteController implements LoyaltyEventConfigurationDeleteControllerApi {
    private final LoyaltyEventDeleteServicePort loyaltyEventDeleteServicePort;

    public LoyaltyEventConfigurationDeleteController(LoyaltyEventDeleteServicePort loyaltyEventDeleteServicePort) {
        this.loyaltyEventDeleteServicePort = loyaltyEventDeleteServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventConfigurationResponseObject> deleteLoyaltyEventConfigurationById(@PathVariable UUID loyaltyEventConfigurationId) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyEventConfigurationId, "LoyaltyEventConfiguration", "loyaltyEventConfigurationId");

        // Delete (with validations)
        loyaltyEventDeleteServicePort.deleteLoyaltyEventConfigurationById(loyaltyEventConfigurationId);

        // Prepare response
        return LoyaltyEventConfigurationResponseFactory.preparePositiveResponseEntity(
                String.format("1 Loyalty Event Configuration deleted with ID: %s", loyaltyEventConfigurationId),
                new ArrayList<>());
    }
}
