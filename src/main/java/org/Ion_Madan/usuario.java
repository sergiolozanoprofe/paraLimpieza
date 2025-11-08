package org.Ion_Madan;

public class usuario {

    public static String COMPANY_NAME = "OpenAI";

    private String nombre_usuario;
    private String correo_electronico;
    private int age;

    public usuario(String nombre_usuario, String correo_electronico) {
        this.nombre_usuario = nombre_usuario;
        this.correo_electronico = correo_electronico;
    }

    public String getNombre_usuario(){
        return nombre_usuario;
    }

    public String getemail() {
        return correo_electronico;
    }

    public String toString(){
        return "User: " + nombre_usuario + " (" + correo_electronico + ")";
    }
}
