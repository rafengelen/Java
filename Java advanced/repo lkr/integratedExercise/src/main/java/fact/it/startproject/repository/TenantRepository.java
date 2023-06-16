package fact.it.startproject.repository;

import fact.it.startproject.model.Property;
import fact.it.startproject.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository  extends JpaRepository<Tenant, Long> {
}
