package org.joserodriguez;

public class usuario {

    public static String COMPANY_NAME = constante.COMPANY_NAME;

    private String username;
    private String email;
    private int age;

    public usuario(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getemail() {
        return email;
    }

    @Override
    public String toString() {
        // Se usa la constante para definir el formato
        return String.format(constante.FORMATO_USUARIO, username, email);
    }
}
