package org.keran.domain.validator.loyaltyCustomer;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.exception.loyaltyCustomer.LoyaltyCustomerNumberAlreadyExistsException;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoyaltyCustomerValidator {
    private final String entityName = "LoyaltyCustomer";

    private final LoyaltyCustomerFindServicePort loyaltyCustomerFindServicePort;

    public LoyaltyCustomerValidator(LoyaltyCustomerFindServicePort loyaltyCustomerFindServicePort) {
        this.loyaltyCustomerFindServicePort = loyaltyCustomerFindServicePort;
    }

    /**
     * Validates if loyalty customer exists
     * Throws {@link EntityNotFoundException} if not exists
     * @param id Loyalty Customer ID
     */
    public void validateLoyaltyCustomerExists(UUID id) {
        boolean loyaltyCustomerExists = loyaltyCustomerFindServicePort.existsById(id);

        if (!loyaltyCustomerExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if loyalty customer does not already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id Loyalty Customer ID
     */
    public void validateLoyaltyCustomerNotExists(UUID id) {
        boolean loyaltyCustomerExists = loyaltyCustomerFindServicePort.existsById(id);

        if (loyaltyCustomerExists) {
            throw new EntityAlreadyExistsException(entityName, id.toString());
        }
    }


    /**
     * Validates if loyalty customer number does not already exist
     * Throws {@link LoyaltyCustomerNumberAlreadyExistsException} if already exists
     * @param customerNumber Loyalty Customer ID
     */
    public void validateLoyaltyCustomerNumberNotExists(String customerNumber) {
        boolean loyaltyCustomerExists = loyaltyCustomerFindServicePort.existsByCustomerNumber(customerNumber);

        if (loyaltyCustomerExists) {
            throw new LoyaltyCustomerNumberAlreadyExistsException(customerNumber);
        }
    }
}
