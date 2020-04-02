package com.aor.refactoring.example4;

public class Client {
    private final String name;
    private final String phone;

    public Client(String name, String phone) {
        this.name = name;

        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
