package fact.it.restaurantappstart.model;

public class Administrator extends ExtraTask{
    @Override
    public void update(){
        super.update();

        EntranceCounter subject = EntranceCounter.getInstance();
        System.out.println("Next, I register the " + subject.getNumber() + " customers in the customer file.");

    }
}
