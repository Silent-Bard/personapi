package silent_bard.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import silent_bard.personapi.dto.PersonDTO;
import silent_bard.personapi.entity.Person;

@Mapper
public interface PersonMapper {
    
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
