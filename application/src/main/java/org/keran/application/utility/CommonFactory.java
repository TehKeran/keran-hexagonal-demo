package org.keran.application.utility;

import org.keran.infrastructure.data.Common;
import org.springframework.http.HttpStatus;

public class CommonFactory {

    public static Common prepareCommonWithException(RuntimeException exception, HttpStatus httpRequest) {
        Common common = new Common();
        common.setMessage(exception.getMessage());
        common.setException(exception);
        common.setResponseCode(httpRequest);
        common.setWasSuccess(false);
        return common;
    }

    public static Common prepareCommonWithSuccess(String message) {
        Common common = new Common();
        common.setMessage(message);
        common.setException(null);
        common.setResponseCode(HttpStatus.OK);
        common.setWasSuccess(true);
        return common;
    }


}
