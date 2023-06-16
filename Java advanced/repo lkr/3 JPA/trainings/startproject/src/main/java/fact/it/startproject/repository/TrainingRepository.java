package fact.it.startproject.repository;
import fact.it.startproject.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findAllByOrderByTheme();
    @Query("SELECT DISTINCT t.theme FROM Training t")//GROUP BY t.theme
    List<String> findAllTheme();

    List<Training> findByTheme(String theme);

    List<Training> findByTitleContains(String title);

    @Query("SELECT COUNT(*) from Training t")
    Integer findAmount();
}
