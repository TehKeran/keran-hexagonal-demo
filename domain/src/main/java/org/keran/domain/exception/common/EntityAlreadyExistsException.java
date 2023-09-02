package org.keran.domain.exception.common;

import org.springframework.util.StringUtils;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String entity, String id) {
        super(EntityAlreadyExistsException.generateMessage(entity, id));
    }

    private static String generateMessage(String entity, String id) {
        return String.format("Entity %s with ID: %s already exists in the database",
                StringUtils.capitalize(entity),
                id);
    }
}
