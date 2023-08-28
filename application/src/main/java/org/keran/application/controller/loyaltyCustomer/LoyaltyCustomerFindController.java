package org.keran.application.controller.loyaltyCustomer;

import org.keran.application.exception.common.IdIsNullException;
import org.keran.application.mapper.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.application.utility.LoyaltyCustomerResponseFactory;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerFindServicePort;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/loyaltyCustomer")
public class LoyaltyCustomerFindController implements LoyaltyCustomerFindControllerApi {
    private final Object currentClass = LoyaltyCustomerFindController.class;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;
    private final LoyaltyCustomerFindServicePort loyaltyCustomerFindServicePort;

    public LoyaltyCustomerFindController(LoyaltyCustomerValidator loyaltyCustomerValidator,
                                         LoyaltyCustomerFindServicePort loyaltyCustomerFindServicePort) {
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
        this.loyaltyCustomerFindServicePort = loyaltyCustomerFindServicePort;
    }

    @GetMapping("/{loyaltyCustomerId}")
    @Override
    public ResponseEntity<LoyaltyCustomerResponseObject> findLoyaltyCustomerById(UUID loyaltyCustomerId) {
        // Api validation
        String entity = "LoyaltyCustomer";
        if (loyaltyCustomerId == null) {
            throw new IdIsNullException(currentClass, entity);
        }

        // Business validation
        loyaltyCustomerValidator.validateLoyaltyCustomerExists(loyaltyCustomerId);

        Optional<LoyaltyCustomerDto> loyaltyCustomerDto = loyaltyCustomerFindServicePort.findLoyaltyCustomerById(loyaltyCustomerId);
        if (loyaltyCustomerDto.isPresent()) {
            LoyaltyCustomerApiObject loyaltyCustomerApiObjectCreated =
                    LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToApiObject(loyaltyCustomerDto.get());
            return LoyaltyCustomerResponseFactory.prepareLoyaltyCustomerPositiveResponseEntity(
                    String.format("One loyalty customer found with ID: %s", loyaltyCustomerDto.get().getId().toString()),
                    Collections.singletonList(loyaltyCustomerApiObjectCreated));
        } else {
            throw new EntityNotFoundException(currentClass, entity, loyaltyCustomerId.toString());
        }
    }
}
