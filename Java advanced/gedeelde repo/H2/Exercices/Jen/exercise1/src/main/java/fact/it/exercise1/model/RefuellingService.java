package fact.it.exercise1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefuellingService {
    private List<Refuelling> refuellingList = new ArrayList<>();

    public RefuellingService() {
        this.refuellingList.add(new Refuelling(1, 200, 700, 30));
        this.refuellingList.add(new Refuelling(2, 100, 300, 25));
        this.refuellingList.add(new Refuelling(3, 600, 900, 15));
    }

    public List<Refuelling> getRefuellingList() {
        return refuellingList;
    }

    public void setRefuellingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Optional<Refuelling> getOptionalRefuellingById(int id){
        return getRefuellingList().stream().filter(r -> r.getId() == id).findFirst();
    }

    public Refuelling addRefuelling(Refuelling newRefuelling){
        newRefuelling.setId(this.refuellingList.size() + 1);

        this.refuellingList.add(newRefuelling);

        return this.refuellingList.get(this.refuellingList.size() - 1);
    }

    public Refuelling updateRefuellingById(Refuelling updateRefuelling, int id){
        Optional<Refuelling> refuellingOptional = getOptionalRefuellingById(id);
        if (refuellingOptional.isPresent()){
            Refuelling refuelling = refuellingOptional.get();
            refuelling.setCurrentMileage(updateRefuelling.getCurrentMileage());
            refuelling.setPreviousMileage(updateRefuelling.getPreviousMileage());
            refuelling.setAmountInLitres(updateRefuelling.getAmountInLitres());
            return refuelling;
        }
        return null;
    }

//    public double getTotalConsumption(){
//
//    }
}
