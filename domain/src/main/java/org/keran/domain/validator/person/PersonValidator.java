package org.keran.domain.validator.person;

import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.person.PersonFindServicePort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonValidator {
    private final String entityName = "Person";
    private final PersonFindServicePort personFindServicePort;

    public PersonValidator(PersonFindServicePort personFindServicePort) {
        this.personFindServicePort = personFindServicePort;
    }

    /**
     * Validates if person exists
     * Throws {@link EntityNotFoundException} if it does not exist
     * @param id person ID
     */
    public void validatePersonExists(UUID id) {
        boolean personExists = personFindServicePort.existsPersonById(id);

        if (!personExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if person doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id person ID
     */
    public void validatePersonNotExists(UUID id) {
        boolean personExists = personFindServicePort.existsPersonById(id);

        if (personExists) {
            throw new EntityAlreadyExistsException(entityName, id.toString());
        }
    }

    /**
     * Validates if address exists
     * Throws {@link EntityNotFoundException} if it does not exist
     * @param id address ID
     */
    public void validateAddressExists(UUID id) {
        boolean addressExists = personFindServicePort.existsAddressById(id);

        if (!addressExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if address doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id address ID
     */
    public void validateAddressNotExists(UUID id) {
        boolean addressExists = personFindServicePort.existsAddressById(id);

        if (addressExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if consent exists
     * Throws {@link EntityNotFoundException} if it does not exist
     * @param id consent ID
     */
    public void validateConsentExists(UUID id) {
        boolean consentExists = personFindServicePort.existsConsentById(id);

        if (!consentExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if consent doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id consent ID
     */
    public void validateConsentNotExists(UUID id) {
        boolean consentExists = personFindServicePort.existsConsentById(id);

        if (consentExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if contact email exists
     * Throws {@link EntityNotFoundException} if it does not exist
     * @param id contact email ID
     */
    public void validateContactEmailExists(UUID id) {
        boolean contactEmailExists = personFindServicePort.existsContactEmailById(id);

        if (!contactEmailExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if consent email doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id consent email ID
     */
    public void validateContactEmailNotExists(UUID id) {
        boolean contactEmailExists = personFindServicePort.existsContactEmailById(id);

        if (contactEmailExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if contact telephone exists
     * Throws {@link EntityNotFoundException} if it does not exist
     * @param id contact telephone ID
     */
    public void validateContactTelephoneExists(UUID id) {
        boolean contactTelephoneExists = personFindServicePort.existsContactTelephoneById(id);

        if (!contactTelephoneExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }

    /**
     * Validates if contact telephone doesn't already exist
     * Throws {@link EntityAlreadyExistsException} if already exists
     * @param id contact telephone ID
     */
    public void validateContactTelephoneNotExists(UUID id) {
        boolean contactTelephoneExists = personFindServicePort.existsContactTelephoneById(id);

        if (contactTelephoneExists) {
            throw new EntityNotFoundException(entityName, id.toString());
        }
    }
}
