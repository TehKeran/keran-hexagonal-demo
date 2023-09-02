package org.keran.application.controller.person;

import org.keran.application.utility.person.PersonResponseFactory;
import org.keran.domain.ports.api.person.PersonDeleteServicePort;
import org.keran.infrastructure.data.PersonResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class PersonDeleteController implements PersonDeleteControllerApi {
    private final PersonDeleteServicePort personDeleteServicePort;

    public PersonDeleteController(PersonDeleteServicePort personDeleteServicePort) {
        this.personDeleteServicePort = personDeleteServicePort;
    }

    @Override
    public ResponseEntity<PersonResponseObject> deletePersonById(@PathVariable UUID personId) {
        // Delete (with validations)
        personDeleteServicePort.deletePersonById(personId);

        // Prepare response
        return PersonResponseFactory.preparePositiveResponseEntity(
                String.format("1 Person deleted with ID: %s", personId),
                new ArrayList<>());
    }
}
