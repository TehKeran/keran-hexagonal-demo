package org.keran.application.controller.loyaltyEventConfiguration;

import org.keran.application.mapper.loyaltyEventConfiguration.LoyaltyEventConfigurationMapper;
import org.keran.application.utility.loyaltyEventConfiguration.LoyaltyEventConfigurationResponseFactory;
import org.keran.application.validator.loyaltyEventConfiguration.LoyaltyEventConfigurationApiValidator;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventAddServicePort;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.keran.infrastructure.data.LoyaltyEventConfigurationResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventConfigurationAddController implements LoyaltyEventConfigurationAddControllerApi {
    private final LoyaltyEventAddServicePort loyaltyEventAddServicePort;

    public LoyaltyEventConfigurationAddController(LoyaltyEventAddServicePort loyaltyEventAddServicePort) {
        this.loyaltyEventAddServicePort = loyaltyEventAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventConfigurationResponseObject> addLoyaltyEventConfigurationById(
            @PathVariable UUID loyaltyProgramId,
            @PathVariable UUID loyaltyEventId,
            @RequestBody LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject) {
        // API validation
        LoyaltyEventConfigurationApiValidator.validateLoyaltyEventConfigurationApiObject(loyaltyEventConfigurationApiObject);

        // Create (with validations)
        loyaltyEventConfigurationApiObject.setLoyaltyProgramId(loyaltyProgramId);
        loyaltyEventConfigurationApiObject.setLoyaltyEventId(loyaltyEventId);
        LoyaltyEventConfigurationDto loyaltyEventConfigurationDto =
                LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationApiObjectToDto(loyaltyEventConfigurationApiObject);
        Optional<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDtoCreated =
                loyaltyEventAddServicePort.addLoyaltyEventConfigurationDto(loyaltyEventConfigurationDto);

        // Prepare response
        if (loyaltyEventConfigurationDtoCreated.isPresent()) {
            LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObjectCreated =
                    LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationDtoToApiObject(loyaltyEventConfigurationDtoCreated.get());
            return LoyaltyEventConfigurationResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event Configuration created with ID: %s",loyaltyEventConfigurationApiObjectCreated.getId()),
                    List.of(loyaltyEventConfigurationApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyEventConfigurationDto.class.getSimpleName());
        }
    }
}
