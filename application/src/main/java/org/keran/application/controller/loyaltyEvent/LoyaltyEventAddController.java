package org.keran.application.controller.loyaltyEvent;

import org.keran.application.mapper.loyaltyEvent.LoyaltyEventMapper;
import org.keran.application.utility.loyaltyEvent.LoyaltyEventResponseFactory;
import org.keran.application.validator.loyaltyEvent.LoyaltyEventApiValidator;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventAddServicePort;
import org.keran.infrastructure.data.LoyaltyEventApiObject;
import org.keran.infrastructure.data.LoyaltyEventResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoyaltyEventAddController implements  LoyaltyEventAddControllerApi {
    private final LoyaltyEventAddServicePort loyaltyEventAddServicePort;

    public LoyaltyEventAddController(LoyaltyEventAddServicePort loyaltyEventAddServicePort) {
        this.loyaltyEventAddServicePort = loyaltyEventAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventResponseObject> addLoyaltyEventById(@RequestBody LoyaltyEventApiObject loyaltyEventApiObject) {
        // API validation:
        LoyaltyEventApiValidator.validateLoyaltyEventApiObject(loyaltyEventApiObject);

        // Create (with validations)
        LoyaltyEventDto loyaltyEventDto = LoyaltyEventMapper.INSTANCE.loyaltyEventApiObjectToDto(loyaltyEventApiObject);
        Optional<LoyaltyEventDto> loyaltyEventDtoCreated = loyaltyEventAddServicePort.addLoyaltyEvent(loyaltyEventDto);

        // Prepare response
        if (loyaltyEventDtoCreated.isPresent()) {
            LoyaltyEventApiObject loyaltyEventApiObjectCreated =
                    LoyaltyEventMapper.INSTANCE.loyaltyEventDtoToApiObject(loyaltyEventDtoCreated.get());
            return LoyaltyEventResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event created with ID: %s", loyaltyEventApiObjectCreated.getId()),
                    List.of(loyaltyEventApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyEventDto.class.getSimpleName());
        }
    }
}
