package org.Santos;

public class Usuario {

    public static String COMPANY_NAME = "OpenAI";

    private String nombreusuario;
    private String Email;
    private int age;

    public Usuario(String NombreUsuario, String Email) {
        this.nombreusuario = NombreUsuario;
        this.Email = Email;
    }

    public String obtenerNombre(){
        return nombreusuario;
    }

    public String obtenerMail() {
        return Email;
    }

    public String toString(){
        return "User: " + nombreusuario + " (" + Email + ")";
    }
}
