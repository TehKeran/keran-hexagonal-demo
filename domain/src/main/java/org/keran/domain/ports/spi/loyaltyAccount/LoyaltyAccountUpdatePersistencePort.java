package org.keran.domain.ports.spi.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;

public interface LoyaltyAccountUpdatePersistencePort {
    LoyaltyAccountDto updateLoyaltyAccount(LoyaltyAccountDto loyaltyAccountDto);
}
