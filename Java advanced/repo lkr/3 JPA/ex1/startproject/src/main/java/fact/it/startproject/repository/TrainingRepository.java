package fact.it.startproject.repository;

import fact.it.startproject.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findAllBy();
    List<Training> findAllByOrderByTheme();


    @Query("SELECT DISTINCT t FROM Training t GROUP BY t.theme")
    List<Training> findUniqueTrainingsByTheme();

    List<Training> findByTitleContaining(String title);

    List<Training> findByTheme(String theme);
}
