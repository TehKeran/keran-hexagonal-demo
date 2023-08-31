package org.keran.application.utility.loyaltyCustomer;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyCustomerApiObject;
import org.keran.infrastructure.data.LoyaltyCustomerResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyCustomerResponseFactory {

    public static ResponseEntity<LoyaltyCustomerResponseObject> preparePositiveResponseEntity(String message,
                                                                                              List<LoyaltyCustomerApiObject> loyaltyCustomerApiObjectList) {
        LoyaltyCustomerResponseObject loyaltyCustomerResponseObject = new LoyaltyCustomerResponseObject();

        loyaltyCustomerResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyCustomerResponseObject.setLoyaltyCustomerApiObjects(loyaltyCustomerApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyCustomerResponseObject);
    }
}
