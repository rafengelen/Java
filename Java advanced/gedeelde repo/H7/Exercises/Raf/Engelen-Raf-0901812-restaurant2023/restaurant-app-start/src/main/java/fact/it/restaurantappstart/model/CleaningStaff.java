package fact.it.restaurantappstart.model;

public class CleaningStaff extends ExtraTask{
    public void clean(){
        System.out.println("I am " + getStaff().getName()+" and now I start also with cleaning.");
    }
}