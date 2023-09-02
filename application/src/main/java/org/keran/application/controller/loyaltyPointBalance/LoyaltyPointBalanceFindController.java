package org.keran.application.controller.loyaltyPointBalance;

import org.keran.application.mapper.loyaltyPointBalance.LoyaltyPointBalanceMapper;
import org.keran.application.utility.loyaltyPointBalance.LoyaltyPointBalanceResponseFactory;
import org.keran.domain.data.loyaltyPointBalance.LoyaltyPointBalanceDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyPointBalance.LoyaltyPointBalanceFindServicePort;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.keran.infrastructure.data.LoyaltyPointBalanceResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyPointBalanceFindController implements LoyaltyPointBalanceFindControllerApi {
    private final LoyaltyPointBalanceFindServicePort loyaltyPointBalanceFindServicePort;

    public LoyaltyPointBalanceFindController(LoyaltyPointBalanceFindServicePort loyaltyPointBalanceFindServicePort) {
        this.loyaltyPointBalanceFindServicePort = loyaltyPointBalanceFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointBalanceResponseObject> findLoyaltyPointBalanceById(@PathVariable UUID loyaltyPointBalanceId) {
        // Find
        Optional<LoyaltyPointBalanceDto> loyaltyPointBalanceDto =
                loyaltyPointBalanceFindServicePort.findLoyaltyPointBalanceById(loyaltyPointBalanceId);
        if (loyaltyPointBalanceDto.isPresent()) {
            LoyaltyPointBalanceApiObject loyaltyPointBalanceApiObject =
                    LoyaltyPointBalanceMapper.INSTANCE.loyaltyPointBalanceDtoToApiObject(loyaltyPointBalanceDto.get());
            return LoyaltyPointBalanceResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Point Balance created with ID: %s", loyaltyPointBalanceId),
                    List.of(loyaltyPointBalanceApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyPointBalanceDto.class.getSimpleName(), loyaltyPointBalanceId.toString());
        }
    }
}
