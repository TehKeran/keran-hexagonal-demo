package org.keran.application.utility;

import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LoyaltyCustomerResponseFactory {

    public static ResponseEntity<LoyaltyCustomerResponseObject> prepareLoyaltyCustomerPositiveResponseEntity(String message,
                                                                                                             List<LoyaltyCustomerApiObject> loyaltyCustomerApiObjectList) {
        LoyaltyCustomerResponseObject loyaltyCustomerResponseObject = new LoyaltyCustomerResponseObject();

        loyaltyCustomerResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyCustomerResponseObject.setLoyaltyCustomerApiObjects(loyaltyCustomerApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyCustomerResponseObject);
    }
}
