package org.keran.application.utility.loyaltyCard;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyCardApiObject;
import org.keran.infrastructure.data.LoyaltyCardResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyCardResponseFactory {
    public static ResponseEntity<LoyaltyCardResponseObject> preparePositiveResponseEntity(String message,
                                                                                          List<LoyaltyCardApiObject> loyaltyCardApiObjectList) {
        LoyaltyCardResponseObject loyaltyCardResponseObject = new LoyaltyCardResponseObject();

        loyaltyCardResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyCardResponseObject.setLoyaltyCardApiObjects(loyaltyCardApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyCardResponseObject);
    }
}
