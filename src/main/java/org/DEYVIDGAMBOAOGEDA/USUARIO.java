package org.DEYVIDGAMBOAOGEDA;

public class USUARIO {

    public static String COMPANY_NAME = "OpenAI";

    private String username;
    private String email;
    private int age;

    public USUARIO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public String getemail() {
        return email;
    }

    public String toString(){
        return "User: " + username + " (" + email + ")";
    }
}
