package org.keran.application.exception.common;

import org.springframework.util.StringUtils;

public class FieldIsMissingException extends RuntimeException {
    public FieldIsMissingException(Object throwable, String entity, String fieldName) {
        super(FieldIsMissingException.generateMessage(throwable.toString(), entity, fieldName));
    }

    private static String generateMessage(String callingClass, String entity, String fieldName) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length - 1];
        return String.format("%s: Field %s.%s is null, it is mandatory",
                StringUtils.capitalize(callingClassSimpleName), entity, fieldName);
    }
}
