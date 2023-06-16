package fact.it.startproject.repository;

import fact.it.startproject.model.Person;
import fact.it.startproject.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
