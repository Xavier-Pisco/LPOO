public abstract class User {
    private String username;

    public  User(String name){
        this.username = name;
    }

    public User(String name, int age) {
        this.username = name + "" + age;
    }

    public String getUsername() {
        return username;
    }
}
