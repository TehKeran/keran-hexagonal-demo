package org.keran.application.controller.loyaltyPointBalance;

import org.keran.application.mapper.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.application.utility.loyaltyPointBalance.LoyaltyPointBalanceResponseFactory;
import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.keran.infrastructure.data.LoyaltyPointBalanceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyPointBalanceUpdateController implements LoyaltyPointBalanceUpdateControllerApi {
    private final LoyaltyPointBalanceUpdateServicePort loyaltyPointBalanceUpdateServicePort;

    public LoyaltyPointBalanceUpdateController(LoyaltyPointBalanceUpdateServicePort loyaltyPointBalanceUpdateServicePort) {
        this.loyaltyPointBalanceUpdateServicePort = loyaltyPointBalanceUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointBalanceResponseObject> updateLoyaltyPointBalance(@PathVariable UUID loyaltyPointBalanceId,
                                                                                       @RequestBody LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject) {
        // Update (with validations)
        loyaltyPointBalanceApiObject.setId(loyaltyPointBalanceId);
        LoyaltyPointBalanceDto loyaltyPointBalanceDto =
                LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceApiObjectToDto(loyaltyPointBalanceApiObject);
        Optional<LoyaltyPointBalanceDto> loyaltyPointBalanceDtoUpdated =
                loyaltyPointBalanceUpdateServicePort.updateLoyaltyPointBalance(loyaltyPointBalanceDto);

        // Prepare response
        if (loyaltyPointBalanceDtoUpdated.isPresent()) {
            LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObjectUpdated =
                    LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceDtoToApiObject(loyaltyPointBalanceDtoUpdated.get());
            return LoyaltyPointBalanceResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Point Balance updated with ID: %s", loyaltyPointBalanceApiObjectUpdated.getId()),
                    List.of(loyaltyPointBalanceApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyPointBalanceDto.class.getSimpleName());
        }
    }
}
