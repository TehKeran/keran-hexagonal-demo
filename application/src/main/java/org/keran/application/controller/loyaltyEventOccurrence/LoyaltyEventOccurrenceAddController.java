package org.keran.application.controller.loyaltyEventOccurrence;

import org.keran.application.mapper.loyaltyEventOccurrence.LoyaltyEventOccurrenceMapper;
import org.keran.application.utility.loyaltyEventOccurrence.LoyaltyEventOccurrenceResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.application.validator.loyaltyEventOccurrence.LoyaltyEventOccurrenceApiValidator;
import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceAddServicePort;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventOccurrenceAddController implements LoyaltyEventOccurrenceAddControllerApi {
    private final LoyaltyEventOccurrenceAddServicePort loyaltyEventOccurrenceAddServicePort;

    public LoyaltyEventOccurrenceAddController(LoyaltyEventOccurrenceAddServicePort loyaltyEventOccurrenceAddServicePort) {
        this.loyaltyEventOccurrenceAddServicePort = loyaltyEventOccurrenceAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventOccurrenceResponseObject> addLoyaltyEventOccurrenceById(@PathVariable UUID loyaltyCustomerId,
                                                                                              @RequestBody LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyCustomerId, "loyaltyCustomer", "loyaltyCustomerId");
        CommonApiValidator.validateEntityExists(loyaltyEventOccurrenceApiObject, "loyaltyEventOccurrenceApiObject");
        LoyaltyEventOccurrenceApiValidator.validateLoyaltyEventOccurrenceApiObject(loyaltyEventOccurrenceApiObject);

        // Create (with validations)
        loyaltyEventOccurrenceApiObject.setLoyaltyCustomerId(loyaltyCustomerId);
        LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto =
                LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceApiObjectToDto(loyaltyEventOccurrenceApiObject);
        Optional<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDtoCreated =
                loyaltyEventOccurrenceAddServicePort.addLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);

        // Prepare response
        if (loyaltyEventOccurrenceDtoCreated.isPresent()) {
            LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObjectCreated =
                    LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceDtoToApiObject(loyaltyEventOccurrenceDtoCreated.get());
            return LoyaltyEventOccurrenceResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event Occurrence created with ID: %s", loyaltyEventOccurrenceApiObjectCreated.getId()),
                    List.of(loyaltyEventOccurrenceApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyEventOccurrenceAddController.class, "LoyaltyEventOccurrence", "null");
        }
    }
}
