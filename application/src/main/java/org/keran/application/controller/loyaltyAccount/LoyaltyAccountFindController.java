package org.keran.application.controller.loyaltyAccount;

import org.keran.application.mapper.loyaltyAccount.LoyaltyAccountMapper;
import org.keran.application.utility.loyaltyAccount.LoyaltyAccountResponseFactory;
import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyAccount.LoyaltyAccountFindServicePort;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.keran.infrastructure.data.LoyaltyAccountResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyAccountFindController implements LoyaltyAccountFindControllerApi {
    private final LoyaltyAccountFindServicePort loyaltyAccountFindServicePort;

    public LoyaltyAccountFindController(LoyaltyAccountFindServicePort loyaltyAccountFindServicePort) {
        this.loyaltyAccountFindServicePort = loyaltyAccountFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyAccountResponseObject> findLoyaltyAccountById(@PathVariable UUID loyaltyAccountId) {
        // Find
        Optional<LoyaltyAccountDto> loyaltyAccountDto = loyaltyAccountFindServicePort.findLoyaltyAccountById(loyaltyAccountId);

        // Prepare response
        if (loyaltyAccountDto.isPresent()) {
            LoyaltyAccountApiObject loyaltyAccountApiObject =
                    LoyaltyAccountMapper.INSTANCE.loyaltyAccountDtoToApiObject(loyaltyAccountDto.get());

            return LoyaltyAccountResponseFactory.preparePositiveResponseEntity(
                    String.format("1 loyalty account found: %s", loyaltyAccountId),
                    List.of(loyaltyAccountApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyAccountDto.class.getSimpleName(), loyaltyAccountId.toString());
        }
    }
}
