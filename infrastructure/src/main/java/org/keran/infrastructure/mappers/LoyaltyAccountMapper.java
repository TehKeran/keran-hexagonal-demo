package org.keran.infrastructure.mappers;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.domain.definition.LoyaltyAccountTypeEnum;
import org.keran.infrastructure.data.postgres.definitions.DefLoyaltyAccountTypePostgres;
import org.keran.infrastructure.data.postgres.loyaltyAccount.LoyaltyAccountPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyAccountMapper {
    LoyaltyAccountMapper INSTANCE = Mappers.getMapper(LoyaltyAccountMapper.class);

    //@Mapping(source="id", target = "id")
    LoyaltyAccountDto loyaltyAccountPostgresToDto(LoyaltyAccountPostgres loyaltyAccountPostgres);
    LoyaltyAccountPostgres loyaltyAccountDtoToPostgres(LoyaltyAccountDto loyaltyAccountDto);
    List<LoyaltyAccountDto> loyaltyAccountPostgresListToDtoList(List<LoyaltyAccountPostgres> loyaltyAccountPostgres);
    List<LoyaltyAccountPostgres> loyaltyAccountDtoListToPostgresList(List<LoyaltyAccountDto> loyaltyAccountDto);

    static LoyaltyAccountTypeEnum map(DefLoyaltyAccountTypePostgres value){
        return LoyaltyAccountTypeEnum.valueOf(value.getValue());
    }

}
