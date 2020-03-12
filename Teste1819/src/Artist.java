public class Artist extends Act {

    public Artist(String n, String c){
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Artist a = (Artist) o;

        return (this.name.equals(a.name) && this.country.equals(a.country));
    }
}
