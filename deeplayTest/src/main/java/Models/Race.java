package Models;

public class Race {
    private Integer id;
    private String raceName;

    public Race(Integer id, String raceName){
        this.id = id;
        this.raceName = raceName;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
