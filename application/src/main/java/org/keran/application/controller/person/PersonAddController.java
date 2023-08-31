package org.keran.application.controller.person;

import org.keran.application.mapper.person.PersonMapper;
import org.keran.application.utility.person.PersonResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.application.validator.person.PersonApiValidator;
import org.keran.domain.data.person.PersonDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.person.PersonAddServicePort;
import org.keran.infrastructure.data.PersonApiObject;
import org.keran.infrastructure.data.PersonResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonAddController implements PersonAddControllerApi {
    private final PersonAddServicePort personAddServicePort;

    public PersonAddController(PersonAddServicePort personAddServicePort) {
        this.personAddServicePort = personAddServicePort;
    }

    @Override
    public ResponseEntity<PersonResponseObject> addPersonById(UUID loyaltyCustomerId, PersonApiObject personApiObject) {
        // API validations
        CommonApiValidator.validateFieldExists(loyaltyCustomerId, "loyaltyCustomer", "loyaltyCustomerId");
        CommonApiValidator.validateEntityExists(personApiObject, "personApiObject");
        PersonApiValidator.validatePersonApiObject(personApiObject);

        // Update (with validations)
        PersonDto personDto = PersonMapper.INSTANCE.personApiObjectToDto(personApiObject);
        Optional<PersonDto> personDtoCreated = personAddServicePort.addPerson(personDto);

        // Prepare response
        if (personDtoCreated.isPresent()) {
            PersonApiObject personApiObjectCreated =
                    PersonMapper.INSTANCE.personDtoToApiObject(personDtoCreated.get());
            return PersonResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Person created with ID: %s", personApiObjectCreated.getId()),
                    List.of(personApiObjectCreated));
        }
        else {
            throw new EntityNotCreatedException(PersonAddController.class, "Person", "null");
        }
    }
}
