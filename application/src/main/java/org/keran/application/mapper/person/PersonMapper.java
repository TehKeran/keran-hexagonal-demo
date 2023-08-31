package org.keran.application.mapper.person;

import org.keran.domain.data.person.PersonDto;
import org.keran.infrastructure.data.PersonApiObject;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDto personApiObjectToDto(PersonApiObject personApiObject);
    PersonApiObject personDtoToApiObject(PersonDto personDto);
    List<PersonDto> personApiObjectListToDtoList(List<PersonApiObject> personApiObjectList);
    List<PersonApiObject> personDtoListToApiObjectList(List<PersonDto> personDtoList);

    default LocalDateTime map(LocalDate date) {
        return date.atStartOfDay();
    }
}
