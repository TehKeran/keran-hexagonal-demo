package org.keran.application.controller.loyaltyEventConfiguration;

import org.keran.application.mapper.loyaltyEventConfiguration.LoyaltyEventConfigurationMapper;
import org.keran.application.utility.loyaltyEventConfiguration.LoyaltyEventConfigurationResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.keran.infrastructure.data.LoyaltyEventConfigurationResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventConfigurationUpdateController implements LoyaltyEventConfigurationUpdateControllerApi {
    private final LoyaltyEventUpdateServicePort loyaltyEventUpdateServicePort;


    public LoyaltyEventConfigurationUpdateController(LoyaltyEventUpdateServicePort loyaltyEventUpdateServicePort) {
        this.loyaltyEventUpdateServicePort = loyaltyEventUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventConfigurationResponseObject> updateLoyaltyEventConfiguration(@PathVariable UUID loyaltyEventConfigurationId,
                                                                                                   @RequestBody LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyEventConfigurationId, "loyaltyEventConfiguration", "loyaltyEventConfigurationId");
        CommonApiValidator.validateEntityExists(loyaltyEventConfigurationApiObject, "loyaltyEventConfigurationApiObject");

        // Update (with validations)
        loyaltyEventConfigurationApiObject.setId(loyaltyEventConfigurationId);
        LoyaltyEventConfigurationDto loyaltyEventConfigurationDto =
                LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationApiObjectToDto(loyaltyEventConfigurationApiObject);
        Optional<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDtoUpdated =
                loyaltyEventUpdateServicePort.updateLoyaltyEventConfiguration(loyaltyEventConfigurationDto);
        // Prepare response
        if (loyaltyEventConfigurationDtoUpdated.isPresent()) {
            LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObjectUpdated =
                    LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationDtoToApiObject(loyaltyEventConfigurationDtoUpdated.get());
            return LoyaltyEventConfigurationResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event Configuration updated with ID: %s", loyaltyEventConfigurationId),
                    List.of(loyaltyEventConfigurationApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyEventConfigurationUpdateController.class, "LoyaltyEventConfiguration", "null");
        }
    }
}
