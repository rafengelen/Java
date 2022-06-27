package fact.it.exerciselesson.model;

public class Lesson {
    private String courseName;
    private String room;
    private TimeSlot timeslot;

    public Lesson(String courseName, String room, TimeSlot timeslot) {
        this.courseName = courseName;
        this.room = room;
        this.timeslot = timeslot;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public TimeSlot getTimeSlot() {
        return timeslot;
    }

    public void setTimeSlot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    public String showLesson(){
        String message = timeslot.getDay() + ", block "+ timeslot.getBlock() +": " + courseName + " in room " + room;
        return message;
    }
}
