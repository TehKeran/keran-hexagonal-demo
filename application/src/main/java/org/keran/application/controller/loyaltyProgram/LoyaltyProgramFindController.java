package org.keran.application.controller.loyaltyProgram;

import org.keran.application.controller.AbstractController;
import org.keran.application.mapper.loyaltyProgram.LoyaltyProgramMapper;
import org.keran.application.utility.loyaltyProgram.LoyaltyProgramResponseFactory;
import org.keran.application.validator.common.CommonApiValidator;
import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramFindServicePort;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;
import org.keran.infrastructure.data.LoyaltyProgramResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyProgramFindController implements LoyaltyProgramFindControllerApi, AbstractController {
    private final LoyaltyProgramFindServicePort loyaltyProgramFindServicePort;

    public LoyaltyProgramFindController(LoyaltyProgramFindServicePort loyaltyProgramFindServicePort) {
        this.loyaltyProgramFindServicePort = loyaltyProgramFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyProgramResponseObject> findLoyaltyProgramById(@PathVariable UUID loyaltyProgramId) {
        // Find
        Optional<LoyaltyProgramDto> loyaltyProgramDto = loyaltyProgramFindServicePort.findLoyaltyProgramById(loyaltyProgramId);
        // Prepare response
        if (loyaltyProgramDto.isPresent()) {
            LoyaltyProgramApiObject loyaltyProgramApiObject =
                    LoyaltyProgramMapper.INSTANCE.loyaltyProgramDtoToApiObject(loyaltyProgramDto.get());
            return LoyaltyProgramResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Program found with ID: %s", loyaltyProgramId),
                    List.of(loyaltyProgramApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyProgramDto.class.getSimpleName());
        }
    }


    @Override
    public ResponseEntity<LoyaltyProgramResponseObject> getLoyaltyPrograms(Integer pageSize, Integer currentPage) {
        // API validation
        CommonApiValidator.validateQueryParameterField(pageSize, "pageSize");
        CommonApiValidator.validateQueryParameterField(currentPage, "currentPage");

        // Get
        List<LoyaltyProgramDto> loyaltyProgramDtoList =
                loyaltyProgramFindServicePort.getLoyaltyPrograms(pageSize, currentPage);

        // Prepare response
        List<LoyaltyProgramApiObject> loyaltyProgramApiObjectList =
                LoyaltyProgramMapper.INSTANCE.loyaltyProgramDtoListToApiObjectList(loyaltyProgramDtoList);

        return LoyaltyProgramResponseFactory.preparePositiveResponseEntity(
                String.format("%s Loyalty Program(s) found", loyaltyProgramApiObjectList.size()),
                loyaltyProgramApiObjectList
        );
    }

}
