package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.PersonDto;
import org.keran.infrastructure.data.postgres.person.PersonPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personPostgresToDto(PersonPostgres personPostgres);
    PersonPostgres personDtoToPostgres(PersonDto personDto);
    List<PersonDto> personPostgresListToDtoList(List<PersonPostgres> personPostgresList);
    List<PersonPostgres> personDtoListToPostgresList(List<PersonDto> personDtoList);

}
