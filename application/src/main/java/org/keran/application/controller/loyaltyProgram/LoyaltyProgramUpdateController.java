package org.keran.application.controller.loyaltyProgram;

import org.keran.application.mapper.loyaltyProgram.LoyaltyProgramMapper;
import org.keran.application.utility.loyaltyProgram.LoyaltyProgramResponseFactory;
import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;
import org.keran.infrastructure.data.LoyaltyProgramResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyProgramUpdateController implements LoyaltyProgramUpdateControllerApi {
    private final LoyaltyProgramUpdateServicePort loyaltyProgramUpdateServicePort;

    public LoyaltyProgramUpdateController(LoyaltyProgramUpdateServicePort loyaltyProgramUpdateServicePort) {
        this.loyaltyProgramUpdateServicePort = loyaltyProgramUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyProgramResponseObject> updateLoyaltyProgram(@PathVariable UUID loyaltyProgramId,
                                                                             @RequestBody LoyaltyProgramApiObject loyaltyProgramApiObject) {
        // Update (with validations)
        loyaltyProgramApiObject.setId(loyaltyProgramId);
        LoyaltyProgramDto loyaltyProgramDto = LoyaltyProgramMapper.INSTANCE.loyaltyProgramApiObjectToDto(loyaltyProgramApiObject);
        Optional<LoyaltyProgramDto> loyaltyProgramDtoUpdated = loyaltyProgramUpdateServicePort.updateLoyaltyProgram(loyaltyProgramDto);

        // Prepare response
        if (loyaltyProgramDtoUpdated.isPresent()) {
            LoyaltyProgramApiObject loyaltyProgramApiObjectUpdated =
                    LoyaltyProgramMapper.INSTANCE.loyaltyProgramDtoToApiObject(loyaltyProgramDtoUpdated.get());
            return LoyaltyProgramResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Program updated with ID: %s", loyaltyProgramId),
                    List.of(loyaltyProgramApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyProgramDto.class.getSimpleName());
        }
    }
}
