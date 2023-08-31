package org.keran.application.controller.loyaltyPoint;

import org.keran.application.mapper.loyaltyPoint.LoyaltyPointMapper;
import org.keran.application.utility.loyaltyPoint.LoyaltyPointResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.application.validator.loyaltyPoint.LoyaltyPointApiValidator;
import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointAddServicePort;
import org.keran.infrastructure.data.LoyaltyPointApiObject;
import org.keran.infrastructure.data.LoyaltyPointResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoyaltyPointAddController implements LoyaltyPointAddControllerApi {
    private final LoyaltyPointAddServicePort loyaltyPointAddServicePort;


    public LoyaltyPointAddController(LoyaltyPointAddServicePort loyaltyPointAddServicePort) {
        this.loyaltyPointAddServicePort = loyaltyPointAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointResponseObject> addLoyaltyPointById(@RequestBody LoyaltyPointApiObject loyaltyPointApiObject) {
        // API validation
        CommonApiValidator.validateEntityExists(loyaltyPointApiObject, "loyaltyPointApiObject");
        LoyaltyPointApiValidator.validateLoyaltyPointApiObject(loyaltyPointApiObject);

        // Create (with validations)
        LoyaltyPointDto loyaltyPointDto = LoyaltyPointMapper.INSTANCE.loyaltyPointApiObjectToDto(loyaltyPointApiObject);
        Optional<LoyaltyPointDto> loyaltyPointDtoCreated =
                loyaltyPointAddServicePort.addLoyaltyPoint(loyaltyPointDto);
        // Prepare response
        if (loyaltyPointDtoCreated.isPresent()) {
            LoyaltyPointApiObject loyaltyPointApiObjectCreated =
                    LoyaltyPointMapper.INSTANCE.loyaltyPointDtoToApiObject(loyaltyPointDtoCreated.get());
            return LoyaltyPointResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Point created with ID: %s", loyaltyPointApiObjectCreated.getId()),
                    List.of(loyaltyPointApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyPointAddController.class, "LoyaltyPoint", "null");
        }
    }
}
