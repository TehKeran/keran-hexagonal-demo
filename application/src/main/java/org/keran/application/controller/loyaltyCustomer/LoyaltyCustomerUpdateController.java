package org.keran.application.controller.loyaltyCustomer;

import org.keran.application.mapper.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.application.utility.loyaltyCustomer.LoyaltyCustomerResponseFactory;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyCustomerUpdateController implements LoyaltyCustomerUpdateControllerApi {
    private final LoyaltyCustomerUpdateServicePort loyaltyCustomerUpdateServicePort;

    public LoyaltyCustomerUpdateController(LoyaltyCustomerUpdateServicePort loyaltyCustomerUpdateServicePort) {
        this.loyaltyCustomerUpdateServicePort = loyaltyCustomerUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyCustomerResponseObject> updateLoyaltyCustomer(@PathVariable UUID loyaltyCustomerId,
                                                                               @RequestBody LoyaltyCustomerApiObject loyaltyCustomerApiObject) {
        // Update (with validations)
        loyaltyCustomerApiObject.setId(loyaltyCustomerId);
        LoyaltyCustomerDto loyaltyCustomerDto = LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerApiObjectToDto(loyaltyCustomerApiObject);
        Optional<LoyaltyCustomerDto> loyaltyCustomerDtoUpdated =
                loyaltyCustomerUpdateServicePort.updateLoyaltyCustomer(loyaltyCustomerDto);
        // Prepare response
        if (loyaltyCustomerDtoUpdated.isPresent()) {
            LoyaltyCustomerApiObject loyaltyCustomerApiObjectUpdated =
                    LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToApiObject(loyaltyCustomerDtoUpdated.get());
            return LoyaltyCustomerResponseFactory.preparePositiveResponseEntity(
                    String.format("1 loyalty customer with ID: %s updated successfully", loyaltyCustomerId),
                    List.of(loyaltyCustomerApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyCustomerApiObject.class.getSimpleName());
        }
    }
}
