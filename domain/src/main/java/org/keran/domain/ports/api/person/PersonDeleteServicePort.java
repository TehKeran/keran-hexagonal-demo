package org.keran.domain.ports.api.person;

import java.util.UUID;

public interface PersonDeleteServicePort {
    void deletePersonById(UUID id);
    void deleteAddressById(UUID id);
    void deleteConsentById(UUID id);
    void deleteContactEmailById(UUID id);
    void deleteContactTelephoneById(UUID id);
}
