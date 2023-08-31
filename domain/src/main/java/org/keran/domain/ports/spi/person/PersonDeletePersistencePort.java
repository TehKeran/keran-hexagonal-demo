package org.keran.domain.ports.spi.person;

import java.util.UUID;

public interface PersonDeletePersistencePort {
    void deletePersonById(UUID id);
    void deleteAddressById(UUID id);
    void deleteAddressByPersonId(UUID personId);
    void deleteConsentById(UUID id);
    void deleteConsentByLoyaltyCustomerId(UUID loyaltyCustomerId);
    void deleteContactEmailById(UUID id);
    void deleteContactEmailByPersonId(UUID personId);
    void deleteContactTelephoneById(UUID id);
    void deleteContactTelephoneByPersonId(UUID personId);
}
