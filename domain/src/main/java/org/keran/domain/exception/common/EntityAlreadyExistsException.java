package org.keran.domain.exception.common;

import org.springframework.util.StringUtils;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(Object throwable, String entity, String id) {
        super(EntityAlreadyExistsException.generateMessage(throwable.toString(), entity, id));
    }

    private static String generateMessage(String callingClass, String entity, String id) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length-1];
        return String.format("%s: the entity %s with ID: %s already exists in the database",
                StringUtils.capitalize(callingClassSimpleName),
                StringUtils.capitalize(entity),
                id);
    }
}
