package org.keran.application.utility.loyaltyPoint;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyPointApiObject;
import org.keran.infrastructure.data.LoyaltyPointResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyPointResponseFactory {
    public static ResponseEntity<LoyaltyPointResponseObject> preparePositiveResponseEntity(String message,
                                                                                           List<LoyaltyPointApiObject> loyaltyPointApiObjectList) {
        LoyaltyPointResponseObject loyaltyPointResponseObject = new LoyaltyPointResponseObject();

        loyaltyPointResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyPointResponseObject.setLoyaltyPointApiObjects(loyaltyPointApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyPointResponseObject);
    }
}
