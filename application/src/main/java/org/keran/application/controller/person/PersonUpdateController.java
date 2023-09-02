package org.keran.application.controller.person;

import org.keran.application.mapper.person.PersonMapper;
import org.keran.application.utility.person.PersonResponseFactory;
import org.keran.domain.data.person.PersonDto;
import org.keran.domain.exception.common.EntityNotCreatedException;
import org.keran.domain.ports.api.person.PersonUpdateServicePort;
import org.keran.infrastructure.data.PersonApiObject;
import org.keran.infrastructure.data.PersonResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonUpdateController implements PersonUpdateControllerApi {
    private final PersonUpdateServicePort personUpdateServicePort;

    public PersonUpdateController(PersonUpdateServicePort personUpdateServicePort) {
        this.personUpdateServicePort = personUpdateServicePort;
    }

    @Override
    public ResponseEntity<PersonResponseObject> updatePerson(@PathVariable UUID personId,
                                                             @RequestBody PersonApiObject personApiObject) {
        // Update (with validations)
        personApiObject.setId(personId);
        PersonDto personDto = PersonMapper.INSTANCE.personApiObjectToDto(personApiObject);
        Optional<PersonDto> personDtoUpdated = personUpdateServicePort.updatePerson(personDto);

        // Prepare response
        if (personDtoUpdated.isPresent()) {
            PersonApiObject personApiObjectUpdated = PersonMapper.INSTANCE.personDtoToApiObject(personDtoUpdated.get());
            return PersonResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Person updated with ID: %s", personId),
                    List.of(personApiObjectUpdated));
        }
        else {
            throw new EntityNotCreatedException(PersonDto.class.getSimpleName());
        }
    }
}
