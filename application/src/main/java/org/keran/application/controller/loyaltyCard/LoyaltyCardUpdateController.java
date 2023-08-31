package org.keran.application.controller.loyaltyCard;

import org.keran.application.mapper.loyaltyCard.LoyaltyCardMapper;
import org.keran.application.utility.loyaltyCard.LoyaltyCardResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.keran.infrastructure.data.LoyaltyCardResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyCardUpdateController implements LoyaltyCardUpdateControllerApi {
    private final LoyaltyCardUpdateServicePort loyaltyCardUpdateServicePort;

    public LoyaltyCardUpdateController(LoyaltyCardUpdateServicePort loyaltyCardUpdateServicePort) {
        this.loyaltyCardUpdateServicePort = loyaltyCardUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyCardResponseObject> updateLoyaltyCard(@PathVariable UUID loyaltyCardId, @RequestBody LoyaltyCardApiObject loyaltyCardApiObject) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyCardApiObject, "LoyaltyCard", "loyaltyCardId");
        CommonApiValidator.validateEntityExists(loyaltyCardApiObject, "loyaltyCardApiObject");

        // Update (with validation)
        loyaltyCardApiObject.setId(loyaltyCardId);
        LoyaltyCardDto loyaltyCardDto = LoyaltyCardMapper.INSTANCE.loyaltyCardApiObjectToDto(loyaltyCardApiObject);
        Optional<LoyaltyCardDto> loyaltyCardDtoUpdated = loyaltyCardUpdateServicePort.updateLoyaltyCard(loyaltyCardDto);

        // Prepare response
        if (loyaltyCardDtoUpdated.isPresent()) {
            LoyaltyCardApiObject loyaltyCardApiObjectUpdated =
                    LoyaltyCardMapper.INSTANCE.loyaltyCardDtoToApiObject(loyaltyCardDtoUpdated.get());
            return LoyaltyCardResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty card updated with ID: %s", loyaltyCardId),
                    List.of(loyaltyCardApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyCardUpdateController.class, "LoyaltyCard", "null");
        }
    }
}
