package org.keran.domain.service.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.domain.ports.api.loyaltyProgram.LoyaltyProgramAddServicePort;
import org.keran.domain.ports.spi.loyaltyProgram.LoyaltyProgramAddPersistencePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoyaltyProgramAddService implements LoyaltyProgramAddServicePort {
    private final LoyaltyProgramAddPersistencePort loyaltyProgramAddPersistencePort;

    public LoyaltyProgramAddService(LoyaltyProgramAddPersistencePort loyaltyProgramAddPersistencePort) {
        this.loyaltyProgramAddPersistencePort = loyaltyProgramAddPersistencePort;
    }

    @Override
    public Optional<LoyaltyProgramDto> addLoyaltyProgram(LoyaltyProgramDto loyaltyProgramDto) {
        return loyaltyProgramAddPersistencePort.addLoyaltyProgram(loyaltyProgramDto);
    }
}
