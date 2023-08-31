package org.keran.application.exceptionHandler;

import org.keran.application.exception.loyaltyCustomer.LoyaltyCustomerNumberIsNullException;
import org.keran.application.utility.common.ResponseEntityFactory;
import org.keran.domain.exception.loyaltyCustomer.LoyaltyCustomerNumberAlreadyExistsException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class LoyaltyCustomerRestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LoyaltyCustomerNumberAlreadyExistsException.class)
    protected ResponseEntity<Object> handleException(
            LoyaltyCustomerNumberAlreadyExistsException ex) {
        return ResponseEntityFactory.prepareNegativeResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoyaltyCustomerNumberIsNullException.class)
    protected ResponseEntity<Object> handleException(
            LoyaltyCustomerNumberIsNullException ex) {
        return ResponseEntityFactory.prepareNegativeResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }
}
