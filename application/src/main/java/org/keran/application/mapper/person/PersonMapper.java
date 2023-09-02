package org.keran.application.mapper.person;

import org.keran.domain.data.person.PersonDto;
import org.keran.infrastructure.data.PersonApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    @Mapping(source = "loyaltyCustomerId", target = "loyaltyCustomerDto.id")
    PersonDto personApiObjectToDto(PersonApiObject personApiObject);
    @Mapping(source = "loyaltyCustomerDto.id", target = "loyaltyCustomerId")
    PersonApiObject personDtoToApiObject(PersonDto personDto);
    List<PersonDto> personApiObjectListToDtoList(List<PersonApiObject> personApiObjectList);
    List<PersonApiObject> personDtoListToApiObjectList(List<PersonDto> personDtoList);

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
