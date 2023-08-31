package org.keran.application.utility.loyaltyPointBalance;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyPointBalanceApiObject;
import org.keran.infrastructure.data.LoyaltyPointBalanceResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyPointBalanceResponseFactory {
    public static ResponseEntity<LoyaltyPointBalanceResponseObject> preparePositiveResponseEntity(String message,
                                                                                           List<LoyaltyPointBalanceApiObject> loyaltyPointBalanceApiObjectList) {
        LoyaltyPointBalanceResponseObject loyaltyPointBalanceResponseObject = new LoyaltyPointBalanceResponseObject();

        loyaltyPointBalanceResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyPointBalanceResponseObject.setLoyaltyPointBalanceApiObjects(loyaltyPointBalanceApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyPointBalanceResponseObject);
    }
}
