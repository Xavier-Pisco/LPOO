public abstract class Act {
    protected String name, country;

    public Act(String n, String c){
        name = n;
        country = c;
    }

    public abstract String getName();

    public abstract String getCountry();

}
