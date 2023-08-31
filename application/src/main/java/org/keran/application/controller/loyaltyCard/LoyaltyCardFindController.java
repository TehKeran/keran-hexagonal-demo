package org.keran.application.controller.loyaltyCard;

import org.keran.application.mapper.loyaltyCard.LoyaltyCardMapper;
import org.keran.application.utility.loyaltyCard.LoyaltyCardResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardFindServicePort;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.keran.infrastructure.data.LoyaltyCardResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyCardFindController implements LoyaltyCardFindControllerApi {
    private final LoyaltyCardFindServicePort loyaltyCardFindServicePort;

    public LoyaltyCardFindController(LoyaltyCardFindServicePort loyaltyCardFindServicePort) {
        this.loyaltyCardFindServicePort = loyaltyCardFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyCardResponseObject> findLoyaltyCardById(@PathVariable UUID loyaltyCardId) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyCardId, "LoyaltyCard", "loyaltyCardId");
        // Find
        Optional<LoyaltyCardDto> loyaltyCardDto = loyaltyCardFindServicePort.findLoyaltyCardById(loyaltyCardId);
        // Prepare response
        if (loyaltyCardDto.isPresent()) {
            LoyaltyCardApiObject loyaltyCardApiObject =
                    LoyaltyCardMapper.INSTANCE.loyaltyCardDtoToApiObject(loyaltyCardDto.get());
            return LoyaltyCardResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Card found with ID: %s", loyaltyCardDto.get().getId()),
                    List.of(loyaltyCardApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyCardFindController.class, "LoyaltyCard", loyaltyCardId.toString());
        }
    }
}
