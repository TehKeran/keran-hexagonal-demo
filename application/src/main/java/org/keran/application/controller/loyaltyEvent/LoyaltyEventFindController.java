package org.keran.application.controller.loyaltyEvent;

import org.keran.application.mapper.loyaltyEvent.LoyaltyEventMapper;
import org.keran.application.utility.loyaltyEvent.LoyaltyEventResponseFactory;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventFindServicePort;
import org.keran.infrastructure.data.LoyaltyEventApiObject;
import org.keran.infrastructure.data.LoyaltyEventResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventFindController implements LoyaltyEventFindControllerApi {
    private final LoyaltyEventFindServicePort loyaltyEventFindServicePort;

    public LoyaltyEventFindController(LoyaltyEventFindServicePort loyaltyEventFindServicePort) {
        this.loyaltyEventFindServicePort = loyaltyEventFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventResponseObject> findLoyaltyEventById(@PathVariable UUID loyaltyEventId) {
        // Find
        Optional<LoyaltyEventDto> loyaltyEventDto = loyaltyEventFindServicePort.findLoyaltyEventById(loyaltyEventId);

        // Prepare response
        if (loyaltyEventDto.isPresent()) {
            LoyaltyEventApiObject loyaltyEventApiObject =
                    LoyaltyEventMapper.INSTANCE.loyaltyEventDtoToApiObject(loyaltyEventDto.get());
            return LoyaltyEventResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event found with ID: %s", loyaltyEventId),
                    List.of(loyaltyEventApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyEventDto.class.getSimpleName(), loyaltyEventId.toString());
        }
    }
}
