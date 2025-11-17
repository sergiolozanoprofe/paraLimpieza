package org.example;

import java.util.Date;

public class user {

    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    private int age;

    //Autor:Ion Madan. Creacion de un usario y guardado de los valores de cada atributo
    public user(String username, String email) {
        this.username = username;
        this.email = email;
    }
    //Autor:Ion Madan. Devuelve el valores introducidos, como el de usuario y el de correo
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
