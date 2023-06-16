package fact.it.startproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.startproject.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class startprojectApplicationTests {

    @Test
    void toString_appartementFloor3_returnsFloor3() {
        Apartment apartment = new Apartment();

        int floor =3;
        String code = "APA1";

        apartment.setFloor(floor);
        apartment.setCode(code);

        assertEquals(apartment.toString(), "Appartement ("+ code +") on floor: " + floor +" with 0 contract(s)");
    }
    @Test
    void toString_appartementWithContracts_returnsAmountContracts() {
        Apartment apartment = new Apartment();

        int floor =3;
        String code = "APA1";

        List<Contract> contractList = new ArrayList<>();
        contractList.add(new Contract());
        contractList.add(new Contract());
        contractList.add(new Contract());
        contractList.add(new Contract());

        apartment.setFloor(floor);
        apartment.setCode(code);
        apartment.setContractList(contractList);

        assertEquals(apartment.toString(), "Appartement ("+ code +") on floor: " + floor +" with 4 contract(s)");
    }
    @Test
    void toString_detachedHouse_returnsDetached() {
        House house = new House();
        String code = "APA1";

        house.setCode(code);
        house.setTownhouse(false);

        assertEquals(house.toString(), "Detached house ("+ code +") with 0 contract(s)");
    }

}
