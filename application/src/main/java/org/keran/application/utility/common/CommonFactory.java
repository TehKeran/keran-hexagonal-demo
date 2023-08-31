package org.keran.application.utility.common;

import lombok.experimental.UtilityClass;
import org.keran.infrastructure.data.Common;
import org.springframework.http.HttpStatus;

@UtilityClass
public class CommonFactory {

    public static Common prepareCommonWithException(RuntimeException exception, HttpStatus httpStatus) {
        Common common = new Common();
        common.setMessage(exception.getMessage());
        common.setException(exception);
        common.setResponseCode(httpStatus);
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
