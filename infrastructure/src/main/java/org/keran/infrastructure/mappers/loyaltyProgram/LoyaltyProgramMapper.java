package org.keran.infrastructure.mappers.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.infrastructure.data.postgres.loyaltyProgram.LoyaltyProgramPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyProgramMapper {
    LoyaltyProgramMapper INSTANCE = Mappers.getMapper(LoyaltyProgramMapper.class);

    LoyaltyProgramDto loyaltyProgramPostgresToDto(LoyaltyProgramPostgres loyaltyProgramPostgres);
    LoyaltyProgramPostgres loyaltyProgramDtoToPostgres(LoyaltyProgramDto loyaltyProgramDto);
    List<LoyaltyProgramDto> loyaltyProgramPostgresListToDtoList(List<LoyaltyProgramPostgres> loyaltyProgramPostgresList);
    List<LoyaltyProgramPostgres> loyaltyProgramDtoListToPostgresList(List<LoyaltyProgramDto> loyaltyProgramDtoList);
}
