package org.keran.application.mapper.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)

public interface LoyaltyAccountMapper {
    LoyaltyAccountMapper INSTANCE = Mappers.getMapper(LoyaltyAccountMapper.class);
    LoyaltyAccountDto loyaltyAccountApiObjectToDto(LoyaltyAccountApiObject loyaltyAccountApiObject);
    LoyaltyAccountApiObject loyaltyAccountDtoToApiObject(LoyaltyAccountDto loyaltyAccountDto);
    List<LoyaltyAccountDto> loyaltyAccountApiObjectListToDtoList(List<LoyaltyAccountApiObject> loyaltyAccountApiObjectList);
    List<LoyaltyAccountApiObject> loyaltyAccountDtoListToApiObjectList(List<LoyaltyAccountDto> loyaltyAccountDtoList);
}
