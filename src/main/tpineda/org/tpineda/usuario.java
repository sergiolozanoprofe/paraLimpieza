package org.tpineda;

public record usuario(String username, String email) {

    // --Commented out by Inspection (9/11/25, 00:36):public static String COMPANY_NAME = "OpenAI";

    // --Commented out by Inspection (9/11/25, 00:36):private int age;

    public String toString() {
        return "User: " + username + " (" + email + ")";
    }
}
