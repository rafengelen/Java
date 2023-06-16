package fact.it.refuelling.model;

import java.util.ArrayList;
import java.util.Optional;

public class RefuellingService {

    private ArrayList<Refuelling> refuellingList = new ArrayList<>();
    public RefuellingService() {
        refuellingList.add(new Refuelling(1,100,200,10.45));
        refuellingList.add(new Refuelling(2,79,789,138.4));
        refuellingList.add(new Refuelling(3,69,420,69.420));

    }
    public Optional<Refuelling> getOptionalRefuellingById(int id){
        return refuellingList.stream().filter(r->r.getId() == id).findFirst();
    }

    public ArrayList<Refuelling> getRefuellingList() {
        return refuellingList;
    }

    public void setRefuellingList(ArrayList<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Refuelling addRefuelling(Refuelling newRefuelling){
        newRefuelling.setId(this.refuellingList.size());
        refuellingList.add(newRefuelling);
        return newRefuelling;
    }

    public Refuelling updateRefuellingById(Refuelling updateRefuelling, int id){
        Optional<Refuelling> optionalRefuelling = getOptionalRefuellingById(id);
        if(optionalRefuelling.isPresent()){
            Refuelling refuelling = optionalRefuelling.get();
            refuelling.setPreviousMileage(updateRefuelling.getPreviousMileage());
            refuelling.setCurrentMileage(updateRefuelling.getCurrentMileage());
            refuelling.setAmountInLitres(updateRefuelling.getAmountInLitres());

            return refuelling;
        }
        return null;
    }
    public double getTotalConsumption(){
        return this.refuellingList.stream().mapToDouble(Refuelling::getAmountInLitres).sum();
    }
}
