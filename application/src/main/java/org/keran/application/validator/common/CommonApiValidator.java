package org.keran.application.validator.common;

import org.keran.application.exception.common.FieldIsMissingException;
import org.springframework.stereotype.Service;

@Service
public class CommonApiValidator {
    private CommonApiValidator() {}
    public static void validateQueryParameterField(Object field, String fieldName) {
        if (field == null) {
            throw new FieldIsMissingException("ApiQueryParameter", fieldName);
        }
    }
}
