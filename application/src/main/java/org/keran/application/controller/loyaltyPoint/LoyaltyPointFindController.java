package org.keran.application.controller.loyaltyPoint;

import org.keran.application.mapper.loyaltyPoint.LoyaltyPointMapper;
import org.keran.application.utility.loyaltyPoint.LoyaltyPointResponseFactory;
import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.domain.exception.common.EntityNotFoundException;
import org.keran.domain.ports.api.loyaltyPoint.LoyaltyPointFindServicePort;
import org.keran.infrastructure.data.LoyaltyPointApiObject;
import org.keran.infrastructure.data.LoyaltyPointResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoyaltyPointFindController implements LoyaltyPointFindControllerApi {
    private final LoyaltyPointFindServicePort loyaltyPointFindServicePort;

    public LoyaltyPointFindController(LoyaltyPointFindServicePort loyaltyPointFindServicePort) {
        this.loyaltyPointFindServicePort = loyaltyPointFindServicePort;
    }

    @Override
    public ResponseEntity<LoyaltyPointResponseObject> findLoyaltyPointById(@PathVariable UUID loyaltyPointId) {
        // Find
        Optional<LoyaltyPointDto> loyaltyPointDto = loyaltyPointFindServicePort.findLoyaltyPointById(loyaltyPointId);

        // Prepare response
        if (loyaltyPointDto.isPresent()) {
            LoyaltyPointApiObject loyaltyPointApiObject =
                    LoyaltyPointMapper.INSTANCE.loyaltyPointDtoToApiObject(loyaltyPointDto.get());
            return LoyaltyPointResponseFactory.preparePositiveResponseEntity(
                    String.format("1 Loyalty Point found with ID: %s", loyaltyPointId),
                    List.of(loyaltyPointApiObject));
        }
        else {
            throw new EntityNotFoundException(LoyaltyPointDto.class.getSimpleName(), loyaltyPointId.toString());
        }
    }
}
