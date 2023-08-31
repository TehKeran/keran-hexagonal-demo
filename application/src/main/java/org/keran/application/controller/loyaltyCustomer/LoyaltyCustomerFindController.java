package org.keran.application.controller.loyaltyCustomer;

import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.application.mapper.loyaltyCustomer.LoyaltyCustomerMapper;
import org.keran.application.utility.loyaltyCustomer.LoyaltyCustomerResponseFactory;
import org.keran.domain.data.loyaltyCustomer.LoyaltyCustomerDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyCustomer.LoyaltyCustomerFindServicePort;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyCustomerFindController implements LoyaltyCustomerFindControllerApi {
    private final Object currentClass = LoyaltyCustomerFindController.class;
    private final LoyaltyCustomerFindServicePort loyaltyCustomerFindServicePort;

    public LoyaltyCustomerFindController(LoyaltyCustomerFindServicePort loyaltyCustomerFindServicePort) {
        this.loyaltyCustomerFindServicePort = loyaltyCustomerFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyCustomerResponseObject> findLoyaltyCustomerById(@PathVariable UUID loyaltyCustomerId) {
        // Api validation
        String entity = "LoyaltyCustomer";
        if (loyaltyCustomerId == null) {
            throw new FieldIsMissingException(currentClass, entity, "LoyaltyCustomerId");
        }

        Optional<LoyaltyCustomerDto> loyaltyCustomerDto = loyaltyCustomerFindServicePort.findLoyaltyCustomerById(loyaltyCustomerId);
        if (loyaltyCustomerDto.isPresent()) {
            LoyaltyCustomerApiObject loyaltyCustomerApiObjectCreated =
                    LoyaltyCustomerMapper.INSTANCE.loyaltyCustomerDtoToApiObject(loyaltyCustomerDto.get());
            return LoyaltyCustomerResponseFactory.preparePositiveResponseEntity(
                    String.format("1 loyalty customer found with ID: %s", loyaltyCustomerDto.get().getId().toString()),
                    List.of(loyaltyCustomerApiObjectCreated));
        } else {
            throw new EntityNotFoundException(currentClass, entity, loyaltyCustomerId.toString());
        }
    }
}
