package org.keran.application.utility.loyaltyEventOccurrence;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceApiObject;
import org.keran.infrastructure.data.LoyaltyEventOccurrenceResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class LoyaltyEventOccurrenceResponseFactory {
    public static ResponseEntity<LoyaltyEventOccurrenceResponseObject> preparePositiveResponseEntity(String message,
                                                                                                        List<LoyaltyEventOccurrenceApiObject> loyaltyEventOccurrenceApiObjectList) {
        LoyaltyEventOccurrenceResponseObject loyaltyEventOccurrenceResponseObject = new LoyaltyEventOccurrenceResponseObject();

        loyaltyEventOccurrenceResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        loyaltyEventOccurrenceResponseObject.setLoyaltyEventOccurrenceApiObjects(loyaltyEventOccurrenceApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyEventOccurrenceResponseObject);
    }
}
