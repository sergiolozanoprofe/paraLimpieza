package org.example;

import java.util.Date;

/**
 * clase q contiene informacion del usuario
 */
public class user {
    /**
     * nombre de la compañia
     * nombre de usuario
     * email
     * edad del usuario
     */
    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    private int age;

    /**
     *devuelve el nombre, email y la edad
     */
    public user(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public String getemail() {
        return email;
    }

    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
