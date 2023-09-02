package org.keran.domain.exception.common;

import org.springframework.util.StringUtils;

public class EntityNotCreatedException extends RuntimeException {
    public EntityNotCreatedException(String entity) {
        super(EntityNotCreatedException.generateMessage(entity));
    }

    private static String generateMessage(String entity) {
        return String.format("Entity %s could not be created or updated!", StringUtils.capitalize(entity));
    }
}
