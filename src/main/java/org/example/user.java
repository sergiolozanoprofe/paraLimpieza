package org.example;

import java.util.Date;

/*
* Creo que en esta clase es donde se guarda la información de los usuarios,
* y es aqui donde se accede desde la clase user manager segun la opcion que hayan elegido en el main
* */

public class user {

    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    private int age;

    /*En el siguiente metodo es donde se guarda la informacion de nuevos usuarios
    * */

    public user(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /*
    * Aqui se da la orden de devolver el nombre de usuario
    * */

    public String getUsername(){
        return username;
    }

    /*
    * Aqui se da la orden de devolver el email*/

    public String getemail() {
        return email;
    }

    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
