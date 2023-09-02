package org.keran.application.controller.loyaltyCustomer;

import org.keran.application.utility.loyaltyCustomer.LoyaltyCustomerResponseFactory;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerDeleteServicePort;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class LoyaltyCustomerDeleteController implements LoyaltyCustomerDeleteControllerApi {
    private final LoyaltyCustomerDeleteServicePort loyaltyCustomerDeleteServicePort;

    public LoyaltyCustomerDeleteController(LoyaltyCustomerDeleteServicePort loyaltyCustomerDeleteServicePort) {
        this.loyaltyCustomerDeleteServicePort = loyaltyCustomerDeleteServicePort;
    }

    @DeleteMapping("/{loyaltyCustomerId}")
    @Override
    @Transactional
    public ResponseEntity<LoyaltyCustomerResponseObject> deleteLoyaltyCustomerById(@PathVariable UUID loyaltyCustomerId) {
        // Delete loyalty customer:
        loyaltyCustomerDeleteServicePort.deleteLoyaltyCustomerById(loyaltyCustomerId);

        // Prepare response:
        String message = String.format("1 Loyalty Customer %s deleted successfully " +
                "(with all underlying objects - accounts with transaction history, point balances, event occurrences, cards)", loyaltyCustomerId);
        return LoyaltyCustomerResponseFactory.preparePositiveResponseEntity(message, new ArrayList<>());
    }
}
