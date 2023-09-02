package org.keran.application.controller.loyaltyPoint;

import org.keran.application.mapper.loyaltyPoint.LoyaltyPointMapper;
import org.keran.application.utility.loyaltyPoint.LoyaltyPointResponseFactory;
import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyPointApiObject;
import org.keran.infrastructure.data.LoyaltyPointResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyPointUpdateController implements LoyaltyPointUpdateControllerApi {
    private final LoyaltyPointUpdateServicePort loyaltyPointUpdateServicePort;

    public LoyaltyPointUpdateController(LoyaltyPointUpdateServicePort loyaltyPointUpdateServicePort) {
        this.loyaltyPointUpdateServicePort = loyaltyPointUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointResponseObject> updateLoyaltyPoint(@PathVariable UUID loyaltyPointId, @RequestBody LoyaltyPointApiObject loyaltyPointApiObject) {
        // Update
        loyaltyPointApiObject.setId(loyaltyPointId);
        LoyaltyPointDto loyaltyPointDto = LoyaltyPointMapper.INSTANCE.loyaltyPointApiObjectToDto(loyaltyPointApiObject);
        Optional<LoyaltyPointDto> loyaltyPointDtoUpdated = loyaltyPointUpdateServicePort.updateLoyaltyPoint(loyaltyPointDto);

        // Prepare response (with validations)
        if (loyaltyPointDtoUpdated.isPresent()) {
            LoyaltyPointApiObject loyaltyPointApiObjectUpdated =
                    LoyaltyPointMapper.INSTANCE.loyaltyPointDtoToApiObject(loyaltyPointDtoUpdated.get());
            return LoyaltyPointResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Point updated with ID: %s", loyaltyPointId),
                    List.of(loyaltyPointApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyPointDto.class.getSimpleName());
        }
    }
}
