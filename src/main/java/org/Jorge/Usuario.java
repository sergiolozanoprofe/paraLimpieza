package org.Jorge;

public class Usuario {

    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    /** la edad*/
    private int age;

    public Usuario(String username, String email) {
        this.username = username;
        this.email = email;
    }
/** comprueba el usuario*/
    public String getUsername(){
        return username;
    }
/** compruba el email*/
    public String getemail() {
        return email;
    }

    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
