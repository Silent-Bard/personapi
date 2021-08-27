package silent_bard.personapi.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silent_bard.personapi.dto.PersonDTO;
import silent_bard.personapi.entity.Person;
import silent_bard.personapi.mapper.PersonMapper;
import silent_bard.personapi.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);
    
    public PersonDTO savePerson(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        person = personRepository.save(person);
        return personMapper.toDTO(person);
    } 

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public PersonDTO updateById(Long id, @Valid PersonDTO personDTO) {
        verifyIfExists(id);
        return savePerson(personDTO);
    }

    private Person verifyIfExists(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
}
