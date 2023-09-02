package org.keran.application.controller.loyaltyEvent;

import org.keran.application.mapper.loyaltyEvent.LoyaltyEventMapper;
import org.keran.application.utility.loyaltyEvent.LoyaltyEventResponseFactory;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyEventApiObject;
import org.keran.infrastructure.data.LoyaltyEventResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventUpdateController implements LoyaltyEventUpdateControllerApi {
    private final LoyaltyEventUpdateServicePort loyaltyEventUpdateServicePort;

    public LoyaltyEventUpdateController(LoyaltyEventUpdateServicePort loyaltyEventUpdateServicePort) {
        this.loyaltyEventUpdateServicePort = loyaltyEventUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventResponseObject> updateLoyaltyEvent(@PathVariable UUID loyaltyEventId,
                                                                         @RequestBody LoyaltyEventApiObject loyaltyEventApiObject) {
        // Update:
        loyaltyEventApiObject.setId(loyaltyEventId);
        LoyaltyEventDto loyaltyEventDto = LoyaltyEventMapper.INSTANCE.loyaltyEventApiObjectToDto(loyaltyEventApiObject);
        Optional<LoyaltyEventDto> loyaltyEventDtoUpdated = loyaltyEventUpdateServicePort.updateLoyaltyEvent(loyaltyEventDto);

        // Prepare response:
        if (loyaltyEventDtoUpdated.isPresent()) {
            LoyaltyEventApiObject loyaltyEventApiObjectUpdated =
                    LoyaltyEventMapper.INSTANCE.loyaltyEventDtoToApiObject(loyaltyEventDtoUpdated.get());
            return LoyaltyEventResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event updated with ID: %s", loyaltyEventId),
                    List.of(loyaltyEventApiObjectUpdated));
        }
        else {
            throw new EntityNotFoundException(LoyaltyEventDto.class.getSimpleName());
        }
    }
}
