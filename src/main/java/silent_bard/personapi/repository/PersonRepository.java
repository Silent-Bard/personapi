package silent_bard.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import silent_bard.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
