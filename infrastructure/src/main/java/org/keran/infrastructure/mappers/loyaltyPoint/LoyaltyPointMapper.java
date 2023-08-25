package org.keran.infrastructure.mappers.loyaltyPoint;

import org.keran.domain.data.loyaltyPoint.LoyaltyPointDto;
import org.keran.infrastructure.data.postgres.loyaltyPoint.LoyaltyPointPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyPointMapper {
    LoyaltyPointMapper INSTANCE = Mappers.getMapper(LoyaltyPointMapper.class);

    LoyaltyPointDto loyaltyPointPostgresToDto(LoyaltyPointPostgres loyaltyPointPostgres);
    LoyaltyPointPostgres loyaltyPointDtoToPostgres(LoyaltyPointDto loyaltyPointDto);
    List<LoyaltyPointDto> loyaltyPointPostgresListToDtoList(List<LoyaltyPointPostgres> loyaltyPointPostgresList);
    List<LoyaltyPointPostgres> loyaltyPointDtoListToPostgresList(List<LoyaltyPointDto> loyaltyPointDtoList);
}
