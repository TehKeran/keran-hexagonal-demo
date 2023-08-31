package org.keran.application.utility.loyaltyAccount;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.keran.infrastructure.data.LoyaltyAccountResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyAccountResponseFactory {
    public static ResponseEntity<LoyaltyAccountResponseObject> preparePositiveResponseEntity(String message,
                                                                                             List<LoyaltyAccountApiObject> loyaltyAccountApiObjectList) {
        LoyaltyAccountResponseObject loyaltyAccountResponseObject = new LoyaltyAccountResponseObject();

        loyaltyAccountResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyAccountResponseObject.setLoyaltyAccountApiObjects(loyaltyAccountApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyAccountResponseObject);
    }
}
