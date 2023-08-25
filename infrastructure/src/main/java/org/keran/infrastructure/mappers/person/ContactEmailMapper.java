package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.ContactEmailDto;
import org.keran.infrastructure.data.postgres.person.ContactEmailPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContactEmailMapper {
    ContactEmailMapper INSTANCE = Mappers.getMapper(ContactEmailMapper.class);
    ContactEmailDto contactEmailPostgresToDto(ContactEmailPostgres contactEmailPostgres);
    ContactEmailPostgres contactEmailDtoToPostgres(ContactEmailDto contactEmailDto);
    List<ContactEmailDto> contactEmailPostgresListToDtoList(List<ContactEmailPostgres> contactEmailPostgresList);
    List<ContactEmailPostgres> contactEmailDtoListToPostgresList(List<ContactEmailDto> contactEmailDtoList);
}
