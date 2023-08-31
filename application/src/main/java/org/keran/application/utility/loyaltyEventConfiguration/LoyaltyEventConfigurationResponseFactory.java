package org.keran.application.utility.loyaltyEventConfiguration;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyEventConfigurationApiObject;
import org.keran.infrastructure.data.LoyaltyEventConfigurationResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyEventConfigurationResponseFactory {
    public static ResponseEntity<LoyaltyEventConfigurationResponseObject> preparePositiveResponseEntity(String message,
                                                                                           List<LoyaltyEventConfigurationApiObject> loyaltyEventConfigurationApiObjectList) {
        LoyaltyEventConfigurationResponseObject loyaltyEventConfigurationResponseObject = new LoyaltyEventConfigurationResponseObject();

        loyaltyEventConfigurationResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyEventConfigurationResponseObject.setLoyaltyEventConfigurationApiObjects(loyaltyEventConfigurationApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyEventConfigurationResponseObject);
    }
}
