package org.imadan;

public record usuario(String nombre_usuario, String correo_electronico) {


    public String getemail() {
        return correo_electronico;
    }

    public String toString() {
        return "User: " + nombre_usuario + " (" + correo_electronico + ")";
    }

    public String getNombreUsuario() {

        return "";
    }

}
