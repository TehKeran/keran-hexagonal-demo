package org.keran.application.controller.loyaltyCustomer;

import org.keran.application.mapper.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.application.utility.loyaltyCustomer.LoyaltyCustomerResponseFactory;
import org.keran.application.validator.loyaltyCustomer.LoyaltyCustomerApiValidator;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerAddServicePort;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoyaltyCustomerAddController implements LoyaltyCustomerAddControllerApi {
    private final LoyaltyCustomerAddServicePort loyaltyCustomerAddServicePort;

    public LoyaltyCustomerAddController(LoyaltyCustomerAddServicePort loyaltyCustomerAddServicePort) {
        this.loyaltyCustomerAddServicePort = loyaltyCustomerAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyCustomerResponseObject> addLoyaltyCustomerById(@RequestBody LoyaltyCustomerApiObject loyaltyCustomerApiObject) {
        // API validation
        LoyaltyCustomerApiValidator.validateLoyaltyCustomerApiObject(loyaltyCustomerApiObject);

        // Create (with validation)
        LoyaltyCustomerDto loyaltyCustomerDto = LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerApiObjectToDto(loyaltyCustomerApiObject);
        Optional<LoyaltyCustomerDto> loyaltyCustomerDtoCreated = loyaltyCustomerAddServicePort.addLoyaltyCustomer(loyaltyCustomerDto);

        if (loyaltyCustomerDtoCreated.isPresent()){
            LoyaltyCustomerApiObject loyaltyCustomerApiObjectCreated =
                    LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToApiObject(loyaltyCustomerDtoCreated.get());
            return LoyaltyCustomerResponseFactory.preparePositiveResponseEntity(
                    String.format("1 loyalty customer created with ID: %s", loyaltyCustomerDtoCreated.get().getId().toString()),
                    List.of(loyaltyCustomerApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyCustomerApiObject.class.getSimpleName());
        }
    }
}
