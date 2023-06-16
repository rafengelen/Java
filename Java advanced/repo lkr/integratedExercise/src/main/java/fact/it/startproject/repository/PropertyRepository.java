package fact.it.startproject.repository;

import fact.it.startproject.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
