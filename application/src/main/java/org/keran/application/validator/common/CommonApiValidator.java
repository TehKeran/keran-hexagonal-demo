package org.keran.application.validator.common;

import lombok.experimental.UtilityClass;
import org.keran.application.exception.common.EntityIsMissingException;
import org.keran.application.exception.common.FieldIsMissingException;

@UtilityClass
public class CommonApiValidator {
    public static void validateFieldExists(Object field, String entityName, String fieldName) {
        if (field == null) {
            throw new FieldIsMissingException(CommonApiValidator.class, entityName, fieldName);
        }
    }
    public static void validateEntityExists(Object field, String entityName) {
        if (field == null) {
            throw new EntityIsMissingException(CommonApiValidator.class, entityName);
        }
    }
}
