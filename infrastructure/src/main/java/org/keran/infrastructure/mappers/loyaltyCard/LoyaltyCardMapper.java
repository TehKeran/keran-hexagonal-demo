package org.keran.infrastructure.mappers.loyaltyCard;

import org.keran.domain.data.loyaltyCard.LoyaltyCardDto;
import org.keran.infrastructure.data.postgres.loyaltyCard.LoyaltyCardPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyCardMapper {
    LoyaltyCardMapper INSTANCE = Mappers.getMapper(LoyaltyCardMapper.class);

    LoyaltyCardDto loyaltyCardPostgresToDto(LoyaltyCardPostgres loyaltyCardPostgres);
    LoyaltyCardPostgres loyaltyCardDtoToPostgres(LoyaltyCardDto loyaltyCardDto);
    List<LoyaltyCardDto> loyaltyCardPostgresListToDtoList(List<LoyaltyCardPostgres> loyaltyCardPostgresList);
    List<LoyaltyCardPostgres> loyaltyCardDtoListToPostgresList(List<LoyaltyCardDto> loyaltyCardDtoList);

}
