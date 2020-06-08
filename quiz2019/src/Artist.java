public class Artist extends Act {
    public Artist(String name, String country) {
        super(name, country);
    }

    @Override
    public boolean containsArtist(Artist artist) {
        return this.equals(artist);
    }


}
