package silent_bard.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silent_bard.personapi.entity.Person;
import silent_bard.personapi.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}
