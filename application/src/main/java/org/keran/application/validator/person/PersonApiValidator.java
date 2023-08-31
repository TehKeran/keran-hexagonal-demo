package org.keran.application.validator.person;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.FieldIsMissingException;
import org.keran.infrastructure.data.PersonApiObject;

@UtilityClass
public class PersonApiValidator {
    private static final Object currentClass = PersonApiValidator.class;
    public static void validatePersonApiObject(PersonApiObject personApiObject) {
        if (personApiObject.getFirstName() == null) {
            throw new FieldIsMissingException(currentClass, "Person", "firstName");
        }
        if (personApiObject.getFirstLastName() == null) {
            throw new FieldIsMissingException(currentClass, "Person", "firstLastName");
        }
        if (personApiObject.getDateOfBirth() == null) {
            throw new FieldIsMissingException(currentClass, "Person", "dateOfBirth");
        }
    }
}
