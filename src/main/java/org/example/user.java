package org.example;

import java.util.Date;

/**
 * @author [wilmer Esau]
 * a rama user suele usarse para trabajar en:
 * la gestión de usuarios,
 * autenticación, registro,
 * perfiles, permisos…
 */
public class user {

    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    private int age;

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
