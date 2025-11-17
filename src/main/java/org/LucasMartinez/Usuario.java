package org.LucasMartinez;

/**
 * Clase que contiene info basica del usuario
 * @author [LucasMartinezRodriguez]
 */
public class Usuario {
    /**
     *Nombre de compañia
     */
    public static String COMPANY_NAME = "OpenAI";
    /**
     *Nombre de usuario
     */
    private String username;
    /**
     *email
     */
    private String email;
    /**
     *edad
     */
    private int age;

    public Usuario(String username, String email) {
        this.username = username;
        this.email = email;
    }
    /**
     *Devuelve el nombre de usuario
     */
    public String getUsername(){
        return username;
    }
    /**
     *devuelve el email
     */
    public String getemail() {
        return email;
    }
    /**
     *devuelve la edad
     */
    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
