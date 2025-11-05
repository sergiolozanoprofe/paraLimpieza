package org.Santos;

public class Usuario {

    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    private int age;

    public Usuario(String NombreUsuario, String Email) {
        this.username = NombreUsuario;
        this.email = Email;
    }

    public String obtenerNombre(){
        return username;
    }

    public String obtenerMail() {
        return email;
    }

    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
