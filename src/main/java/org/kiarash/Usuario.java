package org.kiarash;

/**
 * Representa un Usuario en el sistema con nombre y email.
 * Esta clase sigue el patrón JavaBean con getters y método toString personalizado.
 *
 * @author Kiarash (autor original)
 * @author [Tu Nombre] - ¡Reemplaza con tu nombre real!
 * @version 1.0
 */
public class Usuario {
    // Nombre de empresa compartido entre todas las instancias de Usuario
    public static String NOMBRE_EMPRESA = "OpenAI";

    // Variables de instancia para datos del usuario
    private String nombreUsuario;
    private String correo;

    /**
     * Construye un nuevo Usuario con el nombre y email especificados.
     *
     * @param nombreUsuario el nombre de usuario para el nuevo usuario
     * @param correo la dirección de email para el nuevo usuario
     */
    public Usuario(String nombreUsuario, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
    }

    /**
     * Devuelve el nombre de usuario.
     *
     * @return el nombre de usuario como String
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Devuelve la dirección de email del usuario.
     *
     * @return el email como String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Devuelve una representación en String de este usuario en el formato:
     * "Usuario: [nombre] ([email])"
     *
     * @return string formateado con información del usuario
     */
    public String toString() {
        return "Usuario: " + nombreUsuario + " (" + correo + ")";
    }
}