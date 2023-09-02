package org.keran.application.controller.loyaltyEventConfiguration;

import org.keran.application.mapper.loyaltyEventConfiguration.LoyaltyEventConfigurationMapper;
import org.keran.application.utility.loyaltyEventConfiguration.LoyaltyEventConfigurationResponseFactory;
import org.keran.domain.data.loyaltyEvent.LoyaltyEventConfigurationDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyEvent.LoyaltyEventFindServicePort;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.keran.infrastructure.data.LoyaltyEventConfigurationResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyEventConfigurationFindController implements LoyaltyEventConfigurationFindControllerApi {
    private final LoyaltyEventFindServicePort loyaltyEventFindServicePort;

    public LoyaltyEventConfigurationFindController(LoyaltyEventFindServicePort loyaltyEventFindServicePort) {
        this.loyaltyEventFindServicePort = loyaltyEventFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyEventConfigurationResponseObject> findLoyaltyEventConfigurationById(@PathVariable UUID loyaltyEventConfigurationId) {
        // Find
        Optional<LoyaltyEventConfigurationDto> loyaltyEventConfigurationDto =
                loyaltyEventFindServicePort.findLoyaltyEventConfigurationById(loyaltyEventConfigurationId);

        // Prepare response
        if (loyaltyEventConfigurationDto.isPresent()) {
            LoyaltyEventConfigurationApiObject loyaltyEventConfigurationApiObject =
                    LoyaltyEventConfigurationMapper.INSTANCE.loyaltyEventConfigurationDtoToApiObject(loyaltyEventConfigurationDto.get());

            return LoyaltyEventConfigurationResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Event Configuration found with ID: %s", loyaltyEventConfigurationId),
                    List.of(loyaltyEventConfigurationApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyEventConfigurationDto.class.getSimpleName(), loyaltyEventConfigurationId.toString());
        }
    }
}
