package org.nerea;

/**
 * Esta es la clase usuario, en esta clase metemos dos parametros de entrada
 * que son el nombre yel correo del usuario
 * @param nombreUsuario
 * @param correoElectronico
 */

public record Usuario(String nombreUsuario, String correoElectronico) {

    /**
     * este metodo devuelve el nombre de usuario y el correo electronico al lado entre parentesis y comillaas
     * @return
     */
    public String toString() {
        return "User: " + nombreUsuario + " (" + correoElectronico + ")";
    }

    /**
     * este metodo devuelve el correo electronico
     * @return
     */
    @Override
    public String correoElectronico() {
        return correoElectronico;
    }
}
