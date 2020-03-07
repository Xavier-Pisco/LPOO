import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city, country, date;
    private List<Act> acts;

    public Concert(String ci, String co, String d){
        city = ci;
        country = co;
        date = d;
        acts = new ArrayList<>();
    }

    public List<Act> getActs(){
        return acts;
    }

    public void addAct(Act a){
        acts.add(a);
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return false;

        if (o == null) return false;

        if (o.getClass() != this.getClass()) return false;

        Concert c = (Concert) o;

        return (c.getCity().equals(city) && c.getCountry().equals(country) && c.getDate().equals(date));
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date);
    }
}
