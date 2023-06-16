package fact.it.ex2.model;

public class Course {
    private String name;
    private Integer studyPoints;

    public Course() {
    }

    public Course(String name, Integer studyPoints) {
        this.name = name;
        this.studyPoints = studyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(Integer studyPoints) {
        this.studyPoints = studyPoints;
    }
}
