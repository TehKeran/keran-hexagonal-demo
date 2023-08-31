package org.keran.application.controller.loyaltyProgram;

import org.keran.application.mapper.loyaltyProgram.LoyaltyProgramMapper;
import org.keran.application.utility.loyaltyProgram.LoyaltyProgramResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.application.validator.loyaltyProgram.LoyaltyProgramApiValidator;
import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramAddServicePort;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;
import org.keran.infrastructure.data.LoyaltyProgramResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoyaltyProgramAddController implements LoyaltyProgramAddControllerApi {
    private final LoyaltyProgramAddServicePort loyaltyProgramAddServicePort;

    public LoyaltyProgramAddController(LoyaltyProgramAddServicePort loyaltyProgramAddServicePort) {
        this.loyaltyProgramAddServicePort = loyaltyProgramAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyProgramResponseObject> addLoyaltyProgramById(LoyaltyProgramApiObject loyaltyProgramApiObject) {
        // API validation
        CommonApiValidator.validateEntityExists(loyaltyProgramApiObject, "loyaltyProgramApiObject");
        LoyaltyProgramApiValidator.validateLoyaltyProgramApiObject(loyaltyProgramApiObject);

        // Create (with validations)
        LoyaltyProgramDto loyaltyProgramDto =
                LoyaltyProgramMapper.INSTANCE.loyaltyProgramApiObjectToDto(loyaltyProgramApiObject);
        Optional<LoyaltyProgramDto> loyaltyProgramDtoCreated = loyaltyProgramAddServicePort.addLoyaltyProgram(loyaltyProgramDto);

        // Prepare response
        if (loyaltyProgramDtoCreated.isPresent()) {
            LoyaltyProgramApiObject loyaltyProgramApiObjectCreated =
                    LoyaltyProgramMapper.INSTANCE.loyaltyProgramDtoToApiObject(loyaltyProgramDtoCreated.get());
            return LoyaltyProgramResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Program created with ID: %s", loyaltyProgramApiObjectCreated.getId()),
                    List.of(loyaltyProgramApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyProgramAddController.class, "LoyaltyProgram", "null");
        }
    }
}
