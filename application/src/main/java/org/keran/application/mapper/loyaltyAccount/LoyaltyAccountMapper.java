package org.keran.application.mapper.loyaltyAccount;

import org.keran.domain.data.loyaltyAccount.LoyaltyAccountDto;
import org.keran.infrastructure.data.LoyaltyAccountApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)

public interface LoyaltyAccountMapper {
    LoyaltyAccountMapper INSTANCE = Mappers.getMapper(LoyaltyAccountMapper.class);
    @Mapping(source = "loyaltyCustomerId", target = "loyaltyCustomerDto.id")
    @Mapping(source = "loyaltyProgramId", target = "loyaltyProgramDto.id")
    LoyaltyAccountDto loyaltyAccountApiObjectToDto(LoyaltyAccountApiObject loyaltyAccountApiObject);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerId")
    @Mapping(source = "loyaltyProgramDto.id", target = "loyaltyProgramId")
    LoyaltyAccountApiObject loyaltyAccountDtoToApiObject(LoyaltyAccountDto loyaltyAccountDto);
    List<LoyaltyAccountDto> loyaltyAccountApiObjectListToDtoList(List<LoyaltyAccountApiObject> loyaltyAccountApiObjectList);
    List<LoyaltyAccountApiObject> loyaltyAccountDtoListToApiObjectList(List<LoyaltyAccountDto> loyaltyAccountDtoList);
    static LocalDateTime map(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.atStartOfDay();
    }
    static LocalDate map(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        return dateTime.toLocalDate();
    }
}
