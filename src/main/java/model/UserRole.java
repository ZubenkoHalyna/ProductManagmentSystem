package model;

/**
 * Created by Galinka on 27.04.2017.
 */
public enum UserRole {
    USER, ADMIN;

    static UserRole getUserRole(int number) {
        return (number == 0) ? USER : ADMIN;
    }
}
