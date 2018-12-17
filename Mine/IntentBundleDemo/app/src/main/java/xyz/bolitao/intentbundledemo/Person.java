package xyz.bolitao.intentbundledemo;

import java.io.Serializable;

/**
 * @author Boli Tao
 */
public class Person implements Serializable {
    private String username;
    private String password;
    private String address;

    public Person() {
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
