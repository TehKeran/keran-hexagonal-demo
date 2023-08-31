package org.keran.application.controller.loyaltyAccount;

import org.keran.application.mapper.loyaltyAccount.LoyaltyAccountMapper;
import org.keran.application.utility.loyaltyAccount.LoyaltyAccountResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountUpdateServicePort;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.keran.infrastructure.data.LoyaltyAccountResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyAccountUpdateController implements LoyaltyAccountUpdateControllerApi {
    private final LoyaltyAccountUpdateServicePort loyaltyAccountUpdateServicePort;

    public LoyaltyAccountUpdateController(LoyaltyAccountUpdateServicePort loyaltyAccountUpdateServicePort) {
        this.loyaltyAccountUpdateServicePort = loyaltyAccountUpdateServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyAccountResponseObject> updateLoyaltyAccount(@PathVariable UUID loyaltyAccountId, @RequestBody LoyaltyAccountApiObject loyaltyAccountApiObject) {
        // API validation:
        CommonApiValidator.validateFieldExists(loyaltyAccountId, "LoyaltyAccount", "loyaltyAccountId");
        CommonApiValidator.validateEntityExists(loyaltyAccountApiObject, "LoyaltyAccountApiObject");

        // Update (with validation)
        loyaltyAccountApiObject.setId(loyaltyAccountId);
        LoyaltyAccountDto loyaltyAccountDto = LoyaltyAccountMapper.INSTANCE.loyaltyAccountApiObjectToDto(loyaltyAccountApiObject);
        Optional<LoyaltyAccountDto> loyaltyAccountDtoUpdated =
                loyaltyAccountUpdateServicePort.updateLoyaltyAccount(loyaltyAccountDto);

        // Prepare response
        if (loyaltyAccountDtoUpdated.isPresent()) {
            LoyaltyAccountApiObject loyaltyAccountApiObjectUpdated =
                    LoyaltyAccountMapper.INSTANCE.loyaltyAccountDtoToApiObject(loyaltyAccountDtoUpdated.get());
            return LoyaltyAccountResponseFactory.preparePositiveResponseEntity("1 Loyalty account updated",
                    List.of(loyaltyAccountApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyAccountUpdateController.class, "LoyaltyAccount", loyaltyAccountId.toString());
        }
    }
}
