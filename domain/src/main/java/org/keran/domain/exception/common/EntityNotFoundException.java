package org.keran.domain.exception.common;

import org.springframework.util.StringUtils;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity, String id) {
        super(EntityNotFoundException.generateMessage(entity, id));
    }
    public EntityNotFoundException(String entity) {
        super(EntityNotFoundException.generateMessage(entity));
    }

    private static String generateMessage(String entity, String id) {
        return String.format("Entity %s with ID: %s not found",
                StringUtils.capitalize(entity),
                id);
    }

    private static String generateMessage(String entity) {
        return String.format("Entity %s not found",
                StringUtils.capitalize(entity));
    }
}
