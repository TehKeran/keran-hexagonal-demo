package org.keran.application.controller.loyaltyEventOccurrence;

import org.keran.application.mapper.loyaltyEventOccurrence.LoyaltyEventOccurrenceMapper;
import org.keran.application.utility.loyaltyEventOccurrence.LoyaltyEventOccurrenceResponseFactory;
import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceFindServicePort;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventOccurrenceFindController implements LoyaltyEventOccurrenceFindControllerApi {
    private final LoyaltyEventOccurrenceFindServicePort loyaltyEventOccurrenceFindServicePort;

    public LoyaltyEventOccurrenceFindController(LoyaltyEventOccurrenceFindServicePort loyaltyEventOccurrenceFindServicePort) {
        this.loyaltyEventOccurrenceFindServicePort = loyaltyEventOccurrenceFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventOccurrenceResponseObject> findLoyaltyEventOccurrenceById(@PathVariable UUID loyaltyEventOccurrenceId) {
        // Find
        Optional<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDto =
                loyaltyEventOccurrenceFindServicePort.findLoyaltyEventOccurrenceById(loyaltyEventOccurrenceId);
        // Prepare response
        if (loyaltyEventOccurrenceDto.isPresent()) {
            LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject =
                    LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceDtoToApiObject(loyaltyEventOccurrenceDto.get());

            return LoyaltyEventOccurrenceResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event Occurrence found with ID: %s", loyaltyEventOccurrenceId),
                    List.of(loyaltyEventOccurrenceApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyEventOccurrenceDto.class.getSimpleName(), loyaltyEventOccurrenceId.toString());
        }
    }
}
