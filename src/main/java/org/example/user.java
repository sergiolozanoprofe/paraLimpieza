package org.example;

import java.util.Date;
/**
 * Clase que representa un usuario de la aplicación.
 * Contiene información básica como nombre de usuario, email y edad.
 * @author Alejandro Herrero
 */
public class user {
    /**
     * Nombre de la compañía
     */
    public static String COMPANY_NAME = "OpenAI";
    /**
     * Nombre de usuario
     */
    private String username;
    /**
     * Email del usuario
     */
    private String email;
    /**
     * Edad del usuario
     */
    private int age;

    public user(String username, String email) {
        this.username = username;
        this.email = email;
    }
    /**
     * Devuelve el nombre del usuario
     */
    public String getUsername(){
        return username;
    }
    /**
     * Devuelve el email del usuario
     */
    public String getemail() {
        return email;
    }
    /**
     * Devuelve la edad del usuario
     */
    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
