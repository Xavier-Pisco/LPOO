import java.util.ArrayList;
import java.util.List;

public class Band extends Act {
    public List<Artist> getArtists() {
        return artists;
    }

    private List<Artist> artists = new ArrayList<Artist>();

    public Band(String n,String c){
        super(n,c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addArtist(Artist a){
        artists.add(a);
    }

    public boolean containsArtist(Artist artist){
        for (Artist a: artists){
            if (a.equals(artist)) return true;
        }
        return false;
    }

}
