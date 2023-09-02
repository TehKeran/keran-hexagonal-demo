package org.keran.application.controller.loyaltyPointBalance;

import org.keran.application.mapper.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.application.utility.loyaltyPointBalance.LoyaltyPointBalanceResponseFactory;
import org.keran.application.validator.loyaltyPointBalance.LoyaltyPointBalanceApiValidator;
import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceAddServicePort;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.keran.infrastructure.data.LoyaltyPointBalanceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyPointBalanceAddController implements LoyaltyPointBalanceAddControllerApi {
    private final LoyaltyPointBalanceAddServicePort loyaltyPointBalanceAddServicePort;

    public LoyaltyPointBalanceAddController(LoyaltyPointBalanceAddServicePort loyaltyPointBalanceAddServicePort) {
        this.loyaltyPointBalanceAddServicePort = loyaltyPointBalanceAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointBalanceResponseObject> addLoyaltyPointBalanceById(@PathVariable UUID loyaltyAccountId,
                                                                                        @PathVariable UUID loyaltyPointId,
                                                                                        @RequestBody LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject) {
        // API validation
        LoyaltyPointBalanceApiValidator.validateLoyaltyPointBalanceApiObject(loyaltyPointBalanceApiObject);

        // Create (with validations)
        loyaltyPointBalanceApiObject.setLoyaltyAccountId(loyaltyAccountId);
        loyaltyPointBalanceApiObject.setLoyaltyPointId(loyaltyPointId);
        LoyaltyPointBalanceDto loyaltyPointBalanceDto =
                LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceApiObjectToDto(loyaltyPointBalanceApiObject);
        Optional<LoyaltyPointBalanceDto> loyaltyPointBalanceDtoCreated =
                loyaltyPointBalanceAddServicePort.addLoyaltyPointBalance(loyaltyPointBalanceDto);

        // Prepare response
        if (loyaltyPointBalanceDtoCreated.isPresent()) {
            LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObjectCreated =
                LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceDtoToApiObject(loyaltyPointBalanceDtoCreated.get());
            return LoyaltyPointBalanceResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Point balance created with ID: %s", loyaltyPointBalanceApiObjectCreated.getId()),
                    List.of(loyaltyPointBalanceApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyPointBalanceDto.class.getSimpleName());
        }
    }
}
