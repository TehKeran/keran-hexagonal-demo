package org.keran.application.exception.common;


public class EntityIsMissingException extends RuntimeException {
    public EntityIsMissingException(String entity) {
        super(EntityIsMissingException.generateMessage(entity));
    }

    private static String generateMessage(String entity) {
        return String.format("Entity %s is null or missing, it is mandatory",
                entity);
    }
}
