package org.keran.application.exception.common;

import org.springframework.util.StringUtils;

public class IdIsNullException extends RuntimeException {
    public IdIsNullException(Object throwable, String entity) {
        super(IdIsNullException.generateMessage(throwable.toString(), entity));
    }

    private static String generateMessage(String callingClass, String entity) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length - 1];
        return String.format("%s: ID of entity %s is null, it is mandatory",
                StringUtils.capitalize(callingClassSimpleName), entity);
    }
}
