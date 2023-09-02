package org.keran.application.controller.loyaltyAccount;

import org.keran.application.utility.loyaltyAccount.LoyaltyAccountResponseFactory;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyAccountResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyAccountDeleteController implements LoyaltyAccountDeleteControllerApi {
    private final LoyaltyAccountDeleteServicePort loyaltyAccountDeleteServicePort;

    public LoyaltyAccountDeleteController(LoyaltyAccountDeleteServicePort loyaltyAccountDeleteServicePort) {
        this.loyaltyAccountDeleteServicePort = loyaltyAccountDeleteServicePort;
    }

    @Override
    @Transactional
    public ResponseEntity<LoyaltyAccountResponseObject> deleteLoyaltyAccountById(@PathVariable UUID loyaltyAccountId) {
        // Delete loyalty account (with validations):
        loyaltyAccountDeleteServicePort.deleteLoyaltyAccountById(loyaltyAccountId);

        // Prepare response
        return LoyaltyAccountResponseFactory.preparePositiveResponseEntity(
                String.format("1 loyalty account deleted: %s", loyaltyAccountId), new ArrayList<>());
    }
}
