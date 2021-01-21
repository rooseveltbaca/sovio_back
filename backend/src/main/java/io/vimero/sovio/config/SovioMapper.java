package io.vimero.sovio.config;

import io.vimero.sovio.api.data.PersonData;
import io.vimero.sovio.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SovioMapper {

    SovioMapper INSTANCE = Mappers.getMapper( SovioMapper.class );

    @Mapping(target = "type", defaultValue = "1")
    @Mapping(target = "status", defaultValue = "1")
    @Mapping(target = "createdUser", defaultValue = "1")
    @Mapping(target = "birthdayDate", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    Person toPerson(PersonData dto);

}
