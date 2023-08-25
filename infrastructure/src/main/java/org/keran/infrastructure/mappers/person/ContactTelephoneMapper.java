package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.ContactTelephoneDto;
import org.keran.infrastructure.data.postgres.person.ContactTelephonePostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContactTelephoneMapper {
    ContactTelephoneMapper INSTANCE = Mappers.getMapper(ContactTelephoneMapper.class);

    ContactTelephoneDto contactTelephonePostgresToDto(ContactTelephonePostgres contactTelephonePostgres);
    ContactTelephonePostgres contactTelephoneDtoToPostgres(ContactTelephoneDto contactTelephoneDto);
    List<ContactTelephoneDto> contactTelephonePostgresListToDtoList(List<ContactTelephonePostgres> contactTelephonePostgresList);
    List<ContactTelephonePostgres> contactTelephoneDtoListToPostgresList(List<ContactTelephoneDto> contactTelephoneDtoList);
}
