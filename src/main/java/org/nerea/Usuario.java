package org.nerea;

public class Usuario {

    public static String COMPANY_NAME = "OpenAI";

    private String nombreUsuario;
    private String correoElectronico;
    private int age;

    public Usuario(String nombreUsuario, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String toString(){
        return "User: " + nombreUsuario + " (" + correoElectronico + ")";
    }
}
