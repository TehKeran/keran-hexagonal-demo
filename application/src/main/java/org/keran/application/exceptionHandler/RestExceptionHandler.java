package org.keran.application.exceptionHandler;

import org.keran.application.utility.ResponseEntityFactory;
import org.keran.domain.exception.common.EntityAlreadyExistsException;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleException(
            EntityNotFoundException ex) {
        return ResponseEntityFactory.prepareNegativeResponseEntity(ex, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EntityAlreadyExistsException.class)
    protected ResponseEntity<Object> handleException(
            EntityAlreadyExistsException ex) {
        return ResponseEntityFactory.prepareNegativeResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }
}
