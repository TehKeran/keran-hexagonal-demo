package org.keran.application.exception.common;

public class FieldIsMissingException extends RuntimeException {
    public FieldIsMissingException(String entity, String fieldName) {
        super(FieldIsMissingException.generateMessage(entity, fieldName));
    }

    private static String generateMessage(String entity, String fieldName) {
        return String.format("Field %s.%s is null or missing, it is mandatory",
                entity, fieldName);
    }
}
