package org.nerea;

public record Usuario(String nombreUsuario, String correoElectronico) {

    public String toString() {
        return "User: " + nombreUsuario + " (" + correoElectronico + ")";
    }

    @Override
    public String correoElectronico() {
        return correoElectronico;
    }
}
