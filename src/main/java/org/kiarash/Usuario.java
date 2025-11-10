package org.kiarash;

public class Usuario {
    public static String NOMBRE_EMPRESA = "OpenAI";

    private String nombreUsuario;
    private String correo;

    public Usuario(String nombreUsuario, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String toString() {
        return "Usuario: " + nombreUsuario + " (" + correo + ")";
    }
}