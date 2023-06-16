package fact.it.startproject.repository;

import fact.it.startproject.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findAllByOrderByTheme();

    //give list of all unique themes
    @Query("select distinct t.theme from Training t order by t.theme asc")
    List<String> giveAllUniqueThemes();

    //filter trainings on a specific theme
    List<Training> findAllByThemeEquals(String theme);

    //filter trainings on name
    List<Training> findAllByTitleContains(String searchString);
}
