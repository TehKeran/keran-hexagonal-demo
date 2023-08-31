package org.keran.application.utility.loyaltyEvent;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyEventApiObject;
import org.keran.infrastructure.data.LoyaltyEventResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyEventResponseFactory {
    public static ResponseEntity<LoyaltyEventResponseObject> preparePositiveResponseEntity(String message,
                                                                                              List<LoyaltyEventApiObject> loyaltyEventApiObjectList) {
        LoyaltyEventResponseObject loyaltyEventResponseObject = new LoyaltyEventResponseObject();

        loyaltyEventResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyEventResponseObject.setLoyaltyEventApiObjects(loyaltyEventApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyEventResponseObject);
    }
}
