package org.keran.application.controller.person;

import org.keran.application.mapper.person.PersonMapper;
import org.keran.application.utility.person.PersonResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.person.PersonDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.person.PersonFindServicePort;
import org.keran.infrastructure.data.PersonApiObject;
import org.keran.infrastructure.data.PersonResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonFindController implements PersonFindControllerApi {
    private final PersonFindServicePort personFindServicePort;

    public PersonFindController(PersonFindServicePort personFindServicePort) {
        this.personFindServicePort = personFindServicePort;
    }

    @Override
    public ResponseEntity<PersonResponseObject> findPersonById(UUID personId) {
        // API validation
        CommonApiValidator.validateFieldExists(personId, "person", "personId");

        // Find
        Optional<PersonDto> personDto = personFindServicePort.findPersonById(personId);

        // Prepare response
        if (personDto.isPresent()) {
            PersonApiObject personApiObject = PersonMapper.INSTANCE.personDtoToApiObject(personDto.get());
            return PersonResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Person found with ID: %s", personId),
                    List.of(personApiObject));
        }
        else {
            throw new EntityNotFoundException(PersonFindController.class, "Person", "null");
        }
    }
}
