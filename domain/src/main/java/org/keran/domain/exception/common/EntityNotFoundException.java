package org.keran.domain.exception.common;

import org.springframework.util.StringUtils;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Object throwable, String entity, String id) {
        super(EntityNotFoundException.generateMessage(throwable.toString(), entity, id));
    }

    private static String generateMessage(String callingClass, String entity, String id) {
        String[] callingClassElements = callingClass.split("\\.");
        String callingClassSimpleName = callingClassElements[callingClassElements.length-1];
        return String.format("%s: the entity %s with ID: %s does not exist in the database",
                StringUtils.capitalize(callingClassSimpleName),
                StringUtils.capitalize(entity),
                id);
    }
}
