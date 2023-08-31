package org.keran.application.controller.loyaltyAccount;

import org.keran.application.mapper.loyaltyAccount.LoyaltyAccountMapper;
import org.keran.application.utility.loyaltyAccount.LoyaltyAccountResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.application.validator.loyaltyAccount.LoyaltyAccountApiValidator;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountAddServicePort;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.keran.infrastructure.data.LoyaltyAccountResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyAccountAddController implements LoyaltyAccountAddControllerApi {
    private final LoyaltyAccountAddServicePort loyaltyAccountAddServicePort;

    public LoyaltyAccountAddController(LoyaltyAccountAddServicePort loyaltyAccountAddServicePort) {
        this.loyaltyAccountAddServicePort = loyaltyAccountAddServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyAccountResponseObject> addLoyaltyAccountById(@PathVariable UUID loyaltyCustomerId, @RequestBody LoyaltyAccountApiObject loyaltyAccountApiObject) {
        // API validation
        CommonApiValidator.validateFieldExists(loyaltyCustomerId, "LoyaltyAccount", "LoyaltyCustomerId");
        CommonApiValidator.validateEntityExists(loyaltyAccountApiObject, "LoyaltyAccountApiObject");
        LoyaltyAccountApiValidator.validateLoyaltyAccountApiObject(loyaltyAccountApiObject);

        // Create (with validation)
        loyaltyAccountApiObject.setLoyaltyCustomerId(loyaltyCustomerId);
        LoyaltyAccountDto loyaltyAccountDto = LoyaltyAccountMapper.INSTANCE.loyaltyAccountApiObjectToDto(loyaltyAccountApiObject);
        Optional<LoyaltyAccountDto> loyaltyAccountDtoCreated = loyaltyAccountAddServicePort.addLoyaltyAccount(loyaltyAccountDto);

        // Prepare response
        if (loyaltyAccountDtoCreated.isPresent()) {
            LoyaltyAccountApiObject loyaltyAccountApiObjectCreated =
                    LoyaltyAccountMapper.INSTANCE.loyaltyAccountDtoToApiObject(loyaltyAccountDtoCreated.get());

            return LoyaltyAccountResponseFactory.preparePositiveResponseEntity(
                    String.format("1 loyalty account created for loyalty customer: %s", loyaltyCustomerId.toString()),
                    List.of(loyaltyAccountApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(LoyaltyAccountAddController.class, "LoyaltyAccount", "null");
        }
    }
}
