package org.keran.application.utility.person;

import lombok.experimental.UtilityClass;
import org.keran.application.utility.common.CommonFactory;
import org.keran.infrastructure.data.PersonApiObject;
import org.keran.infrastructure.data.PersonResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class PersonResponseFactory {
    public static ResponseEntity<PersonResponseObject> preparePositiveResponseEntity(String message,
                                                                                    List<PersonApiObject> personApiObjectList) {
        PersonResponseObject personResponseObject = new PersonResponseObject();

        personResponseObject.setCommon(CommonFactory.prepareCommonWithSuccess(message));
        personResponseObject.setPersonApiObjects(personApiObjectList);
        return ResponseEntity.status(HttpStatus.OK).body(personResponseObject);
    }
}
