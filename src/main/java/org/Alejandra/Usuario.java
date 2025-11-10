package org.Alejandra;

import java.util.Date;

public class Usuario {

    public static String COMPANY_NAME = Constantes.NOMBRE_EMPRESA;

    private String username;
    private String email;
    private int age;

    public Usuario(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public String getemail() {
        return email;
    }

    public String toString() {
        return Constantes.TEXTO_USUARIO + username + Constantes.PARENTESIS_ABIERTO
                + email + Constantes.PARENTESIS_CERRADO;
    }
}
