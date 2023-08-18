package org.keran.domain.ports.spi.person;

import java.util.UUID;

public interface PersonDeletePersistencePort {
    void deletePersonById(UUID id);
    void deleteAddressById(UUID id);
    void deleteConsentById(UUID id);
    void deleteContactEmailById(UUID id);
    void deleteContactTelephoneById(UUID id);
}
