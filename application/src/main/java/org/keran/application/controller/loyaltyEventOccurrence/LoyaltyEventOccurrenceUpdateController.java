package org.keran.application.controller.loyaltyEventOccurrence;

import org.keran.application.mapper.loyaltyEventOccurrence.LoyaltyEventOccurrenceMapper;
import org.keran.application.utility.loyaltyEventOccurrence.LoyaltyEventOccurrenceResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.loyaltyEventOccurrence.LoyaltyEventOccurrenceDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyEventOccurrence.LoyaltyEventOccurrenceUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventOccurrenceUpdateController implements LoyaltyEventOccurrenceUpdateControllerApi {
    private final LoyaltyEventOccurrenceUpdateServicePort loyaltyEventOccurrenceUpdateServicePort;

    public LoyaltyEventOccurrenceUpdateController(LoyaltyEventOccurrenceUpdateServicePort loyaltyEventOccurrenceUpdateServicePort) {
        this.loyaltyEventOccurrenceUpdateServicePort = loyaltyEventOccurrenceUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventOccurrenceResponseObject> updateLoyaltyEventOccurrence(@PathVariable UUID loyaltyEventOccurrenceId,
                                                                                             @RequestBody LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObject) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyEventOccurrenceId, "loyaltyEventOccurrence", "loyaltyEventOccurrenceId");
        CommonApiValidator.validateEntityExists(loyaltyEventOccurrenceApiObject, "loyaltyEventOccurrenceApiObject");

        // Update (with validations)
        loyaltyEventOccurrenceApiObject.setId(loyaltyEventOccurrenceId);
        LoyaltyEventOccurrenceDto loyaltyEventOccurrenceDto =
                LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceApiObjectToDto(loyaltyEventOccurrenceApiObject);
        Optional<LoyaltyEventOccurrenceDto> loyaltyEventOccurrenceDtoUpdated =
                loyaltyEventOccurrenceUpdateServicePort.updateLoyaltyEventOccurrence(loyaltyEventOccurrenceDto);
        // Prepare response
        if (loyaltyEventOccurrenceDtoUpdated.isPresent()) {
            LoyaltyEventOccurrenceApiObject loyaltyEventOccurrenceApiObjectUpdated =
                    LoyaltyEventOccurrenceMapper.INSTANCE.loyaltyEventOccurrenceDtoToApiObject(loyaltyEventOccurrenceDtoUpdated.get());
            return LoyaltyEventOccurrenceResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event Occurrence updated with ID: %s", loyaltyEventOccurrenceId),
                    List.of(loyaltyEventOccurrenceApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyEventOccurrenceUpdateController.class, "LoyaltyEventOccurrence", "null");
        }
    }
}
