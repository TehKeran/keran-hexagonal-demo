package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramFindServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramFindPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoyaltyProgramFindService implements LoyaltyProgramFindServicePort {
    private final LoyaltyProgramFindPersistencePort loyaltyProgramFindPersistencePort;

    public LoyaltyProgramFindService(LoyaltyProgramFindPersistencePort loyaltyProgramFindPersistencePort) {
        this.loyaltyProgramFindPersistencePort = loyaltyProgramFindPersistencePort;
    }

    @Override
    public Optional<LoyaltyProgramDto> findLoyaltyProgramById(UUID id) {
        return loyaltyProgramFindPersistencePort.findLoyaltyProgramById(id);
    }

    @Override
    public Optional<LoyaltyProgramDto> findLoyaltyProgramByName(String name) {
        return loyaltyProgramFindPersistencePort.findLoyaltyProgramByName(name);
    }
}
