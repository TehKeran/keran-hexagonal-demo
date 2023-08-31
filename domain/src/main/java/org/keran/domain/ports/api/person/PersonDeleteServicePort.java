package org.keran.domain.ports.api.person;

import java.util.UUID;

public interface PersonDeleteServicePort {

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
