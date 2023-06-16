package fact.it.startproject.repository;

import fact.it.startproject.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
        List<Company> findAllByOrderByLocation();
    }
