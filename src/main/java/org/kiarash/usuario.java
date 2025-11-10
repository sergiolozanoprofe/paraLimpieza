package org.kiarash;

public class usuario {
    public static String NOMBRE_EMPRESA = "OpenAI";

    private String nombreUsuario;
    private String correo;

    public usuario(String nombreUsuario, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
    }

    public String getNombreusuario() {
        return nombreUsuario;
    }

    public String getcorreo() {
        return correo;
    }

    public String toString() {
        return "Usuario: " + nombreUsuario + " (" + correo + ")";
    }
}