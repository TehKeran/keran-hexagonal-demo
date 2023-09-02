package org.keran.application.validator.person;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.PersonApiObject;

@UtilityClass
public class PersonApiValidator {
    public static void validatePersonApiObject(PersonApiObject personApiObject) {
        if (personApiObject.getFirstName() == null) {
            throw new FieldIsMissingException(PersonApiObject.class.getSimpleName(), "firstName");
        }
        if (personApiObject.getFirstLastName() == null) {
            throw new FieldIsMissingException(PersonApiObject.class.getSimpleName(), "firstLastName");
        }
        if (personApiObject.getDateOfBirth() == null) {
            throw new FieldIsMissingException(PersonApiObject.class.getSimpleName(), "dateOfBirth");
        }
    }
}
