package org.keran.application.mapper.loyaltyProgram;

import org.keran.domain.data.loyaltyProgram.LoyaltyProgramDto;
import org.keran.infrastructure.data.LoyaltyProgramApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface LoyaltyProgramMapper {
    LoyaltyProgramMapper INSTANCE = Mappers.getMapper(LoyaltyProgramMapper.class);
    LoyaltyProgramDto loyaltyProgramApiObjectToDto(LoyaltyProgramApiObject loyaltyProgramApiObject);
    LoyaltyProgramApiObject loyaltyProgramDtoToApiObject(LoyaltyProgramDto loyaltyProgramDto);
    List<LoyaltyProgramDto> loyaltyProgramApiObjectListToDtoList(List<LoyaltyProgramApiObject> loyaltyProgramApiObjectList);
    List<LoyaltyProgramApiObject> loyaltyProgramDtoListToApiObjectList(List<LoyaltyProgramDto> loyaltyProgramDtoList);

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
