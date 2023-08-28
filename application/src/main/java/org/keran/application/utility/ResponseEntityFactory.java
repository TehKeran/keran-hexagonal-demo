package org.keran.application.utility;

import org.keran.infrastructure.data.CommonApiErrorResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityFactory {

    public static ResponseEntity<Object> prepareNegativeResponseEntity(RuntimeException exception, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(prepareCommonApiErrorResponseObject(exception, httpStatus));
    }

    private static CommonApiErrorResponseObject prepareCommonApiErrorResponseObject(RuntimeException exception, HttpStatus httpStatus) {
        CommonApiErrorResponseObject commonApiErrorResponseObject = new CommonApiErrorResponseObject();
        commonApiErrorResponseObject.setCommon(CommonFactory.prepareCommonWithException(exception, httpStatus));

        return commonApiErrorResponseObject;
    }
}
