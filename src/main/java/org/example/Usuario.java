package org.example;
/** Comentario: define una clase usuario que representa un correo y un nombre y devuelve la informacion formateada**/
/** @author Marco**/
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

    public String toString(){
        return String.format(Constantes.FORMATO_USUARIO, username, email);
    }
}
