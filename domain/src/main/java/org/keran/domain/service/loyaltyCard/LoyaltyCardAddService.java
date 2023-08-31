package org.keran.domain.service.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.domain.ports.api.loyaltyCard.LoyaltyCardAddServicePort;
import org.keran.domain.ports.spi.loyaltyCard.LoyaltyCardAddPersistencePort;
import org.keran.domain.validator.loyaltyCard.LoyaltyCardValidator;
import org.keran.domain.validator.loyaltyCustomer.LoyaltyCustomerValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyCardAddService implements LoyaltyCardAddServicePort {
    private final LoyaltyCardAddPersistencePort loyaltyCardAddPersistencePort;
    private final LoyaltyCardValidator loyaltyCardValidator;
    private final LoyaltyCustomerValidator loyaltyCustomerValidator;


    public LoyaltyCardAddService(LoyaltyCardAddPersistencePort loyaltyCardAddPersistencePort, LoyaltyCardValidator loyaltyCardValidator, LoyaltyCustomerValidator loyaltyCustomerValidator) {
        this.loyaltyCardAddPersistencePort = loyaltyCardAddPersistencePort;
        this.loyaltyCardValidator = loyaltyCardValidator;
        this.loyaltyCustomerValidator = loyaltyCustomerValidator;
    }

    @Override
    public Optional<LoyaltyCardDto> addLoyaltyCard(LoyaltyCardDto loyaltyCardDto) {
        // Business validation
        // - If ID is provided, it must not exist:
        if (loyaltyCardDto.getId() != null) {
            loyaltyCardValidator.validateLoyaltyCardNotExists(loyaltyCardDto.getLoyaltyCustomerDto().getId());
        }
        // - Loyalty Card number should be unique
        loyaltyCardValidator.validateLoyaltyCardNotExistsByCardNumber(loyaltyCardDto.getCardNumber());
        // - Loyalty customer must exist
        loyaltyCustomerValidator.validateLoyaltyCustomerExists(loyaltyCardDto.getLoyaltyCustomerDto().getId());

        return loyaltyCardAddPersistencePort.addLoyaltyCard(loyaltyCardDto);
    }
}
