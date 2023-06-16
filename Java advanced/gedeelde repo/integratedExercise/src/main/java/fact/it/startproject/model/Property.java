package fact.it.startproject.model;

import javax.persistence.*;
import java.util.*;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private double surface;

    @OneToMany(mappedBy = "property")
    private List<Contract> contractList = new ArrayList<>();

    public Property() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String toString(){
        return "";
    }
}
