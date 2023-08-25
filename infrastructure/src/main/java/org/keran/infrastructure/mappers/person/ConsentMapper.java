package org.keran.infrastructure.mappers.person;

import org.keran.domain.data.person.ConsentDto;
import org.keran.infrastructure.data.postgres.person.ConsentPostgres;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConsentMapper {
    ConsentMapper INSTANCE = Mappers.getMapper(ConsentMapper.class);

    ConsentDto consentPostgresToDto(ConsentPostgres consentPostgres);
    ConsentPostgres consentDtoToPostgres(ConsentDto consentDto);
    List<ConsentDto> consentPostgresListToDtoList(List<ConsentPostgres> consentPostgresList);
    List<ConsentPostgres> consentDtoListToPostgresList(List<ConsentDto> consentDtoList);
}
