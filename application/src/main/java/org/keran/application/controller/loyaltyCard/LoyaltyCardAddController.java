package org.keran.application.controller.loyaltyCard;

import org.keran.application.mapper.loyaltyCard.LoyaltyCardMapper;
import org.keran.application.utility.loyaltyCard.LoyaltyCardResponseFactory;
import org.keran.application.validator.loyaltyCard.LoyaltyCardApiValidator;
import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardAddServicePort;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.keran.infrastructure.data.LoyaltyCardResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyCardAddController implements LoyaltyCardAddControllerApi {
    private final LoyaltyCardAddServicePort loyaltyCardAddServicePort;


    public LoyaltyCardAddController(LoyaltyCardAddServicePort loyaltyCardAddServicePort) {
        this.loyaltyCardAddServicePort = loyaltyCardAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyCardResponseObject> addLoyaltyCardById(
            @PathVariable UUID loyaltyCustomerId,
            @RequestBody LoyaltyCardApiObject loyaltyCardApiObject) {
        // API validation
        LoyaltyCardApiValidator.validateLoyaltyCardApiObject(loyaltyCardApiObject);

        // Create (with validation)
        loyaltyCardApiObject.setLoyaltyCustomerId(loyaltyCustomerId);
        LoyaltyCardDto loyaltyCardDto = LoyaltyCardMapper.INSTANCE.loyaltyCardApiObjectToDto(loyaltyCardApiObject);
        Optional<LoyaltyCardDto> loyaltyCardDtoCreated = loyaltyCardAddServicePort.addLoyaltyCard(loyaltyCardDto);

        // Prepare response
        if (loyaltyCardDtoCreated.isPresent()) {
            LoyaltyCardApiObject loyaltyCardApiObjectCreated =
                    LoyaltyCardMapper.INSTANCE.loyaltyCardDtoToApiObject(loyaltyCardDtoCreated.get());
            return LoyaltyCardResponseFactory.preparePositiveResponseEntity(String.format("1 loyalty card created with ID: %s",
                    loyaltyCardApiObjectCreated.getId().toString()),
                    List.of(loyaltyCardApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyCardDto.class.getSimpleName());
        }
    }
}
