package org.keran.application.utility.loyaltyProgram;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;
import org.keran.infrastructure.data.LoyaltyProgramResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyProgramResponseFactory {
    public static ResponseEntity<LoyaltyProgramResponseObject> preparePositiveResponseEntity(String message,
                                                                                                  List<LoyaltyProgramApiObject> loyaltyProgramApiObjectList) {
        LoyaltyProgramResponseObject loyaltyProgramResponseObject = new LoyaltyProgramResponseObject();

        loyaltyProgramResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyProgramResponseObject.setLoyaltyAccountApiObjects(loyaltyProgramApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyProgramResponseObject);
    }
}
