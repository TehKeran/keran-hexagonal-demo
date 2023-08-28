package org.keran.application.controller.loyaltyCustomer;

import org.keran.application.mapper.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.application.utility.LoyaltyCustomerResponseFactory;
import org.keran.application.validator.loyaltyCustomer.LoyaltyCustomerApiValidator;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerAddServicePort;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/loyaltyCustomer")
public class LoyaltyCustomerAddController implements LoyaltyCustomerAddControllerApi {
    private final Object currentClass = LoyaltyCustomerAddController.class;
    private final LoyaltyCustomerAddServicePort loyaltyCustomerAddServicePort;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;

    public LoyaltyCustomerAddController(LoyaltyCustomerAddServicePort loyaltyCustomerAddServicePort, LoyaltyCustomerValidator loyaltyCustomerValidator) {
        this.loyaltyCustomerAddServicePort = loyaltyCustomerAddServicePort;
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
    }

    @PostMapping
    @Override
    public ResponseEntity<LoyaltyCustomerResponseObject> addLoyaltyCustomerById(LoyaltyCustomerApiObject loyaltyCustomerApiObject) {
        // API validation - customer number must exist:
        LoyaltyCustomerApiValidator.validateLoyaltyCustomerApiObject(loyaltyCustomerApiObject);

        // Business validation - if ID is provided, it must be unique:
        boolean idWasProvidedInRequest = loyaltyCustomerApiObject.getId() != null;
        if (idWasProvidedInRequest) {
            loyaltyCustomerValidator.validateLoyaltyCustomerNotExists(loyaltyCustomerApiObject.getId());
        }

        // Business validation - customer number must be unique:
        loyaltyCustomerValidator.validateLoyaltyCustomerNumberNotExists(loyaltyCustomerApiObject.getCustomerNumber());

        // Prepare response
        Optional<LoyaltyCustomerDto> loyaltyCustomerDtoCreated = loyaltyCustomerAddServicePort.addLoyaltyCustomer(
                LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerApiObjectToDto(loyaltyCustomerApiObject));

        if (loyaltyCustomerDtoCreated.isPresent()){
            LoyaltyCustomerApiObject loyaltyCustomerApiObjectCreated =
                    LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToApiObject(loyaltyCustomerDtoCreated.get());
            return LoyaltyCustomerResponseFactory.prepareLoyaltyCustomerPositiveResponseEntity(
                    String.format("One loyalty customer created with ID: %s", loyaltyCustomerDtoCreated.get().getId().toString()),
                    Collections.singletonList(loyaltyCustomerApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(currentClass, "LoyaltyCustomer", "null");
        }
    }
}
