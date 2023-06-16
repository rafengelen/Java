package fact.it.ex1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefuellingService {
    private List<Refuelling> refuellingList = new ArrayList<>();

    public RefuellingService() {
        this.refuellingList.add(new Refuelling(1,200,250,10.3));
        this.refuellingList.add(new Refuelling(2,250,275,4.3));
        this.refuellingList.add(new Refuelling(3,275,378,25.43));
    }
    public Optional<Refuelling> getOptionalRefuelingById(int id){
        return getRefuellingList().stream().filter(r -> r.getId()==id).findFirst();
    }

    public List<Refuelling> getRefuellingList() {
        return refuellingList;
    }

    public void setRefuellingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Refuelling addRefuelling(Refuelling newRefuelling){
        newRefuelling.setId(refuellingList.size()+1);
        refuellingList.add(newRefuelling);

        return refuellingList.get(refuellingList.size()-1);
    }
    public Refuelling updateRefuellingById(Refuelling updateRefuelling, int id){
        Optional<Refuelling> refuellingOptional = getOptionalRefuelingById(id);
        if(refuellingOptional.isPresent()){
            Refuelling refuelling = refuellingOptional.get();
            refuelling.setAmountInLitres(updateRefuelling.getAmountInLitres());
            refuelling.setPreviousMileage(updateRefuelling.getPreviousMileage());
            refuelling.setCurrentMileage(updateRefuelling.getCurrentMileage());

            return refuelling;
        }
        return null;
    }
    public double getTotalConsumption(){
        return getRefuellingList().stream().mapToDouble(Refuelling::getAmountInLitres).sum();
    }
}
