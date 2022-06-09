package Models;

import java.util.List;

public class Table {
    private Integer idRace;
    private List<PriceObject> priceObject;

    public Table(Integer idRace, List<PriceObject> priceObject){
        this.idRace = idRace;
        this.priceObject = priceObject;
    }

    public Integer getIdRace() {
        return idRace;
    }

    public void setIdRace(Integer idRace) {
        this.idRace = idRace;
    }

    public List<PriceObject> getPriceObject() {
        return priceObject;
    }

    public void setPriceObject(List<PriceObject> priceObject) {
        this.priceObject = priceObject;
    }
}
