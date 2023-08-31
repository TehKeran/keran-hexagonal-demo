package org.keran.application.exception.common;

import org.springframework.util.StringUtils;

public class EntityIsMissingException extends RuntimeException {
    public EntityIsMissingException(Object throwable, String entity) {
        super(EntityIsMissingException.generateMessage(throwable.toString(), entity));
    }

    private static String generateMessage(String callingClass, String entity) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length - 1];
        return String.format("%s: Entity %s is null, it is mandatory",
                StringUtils.capitalize(callingClassSimpleName), entity);
    }
}
