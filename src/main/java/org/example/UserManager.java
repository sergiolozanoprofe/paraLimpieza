package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class UserManager {

    //Autor: Ion Madan. Creacion de un objeto Gson y una lista donde se gaurdaran los usuarios en memoria
    private Gson gson = new Gson();
    private List<user> users = new ArrayList<>();

    public UserManager() {
        load();
    }

    //Autor: Ion Madan.
    public void addUser(user u) {
        if (u == null)
            return;
        users.add(u);
        save();
    }
    //Autor: Ion Madan.Busqueda de usuario para que coincida con el introducido y devuelve el metodo encontrado
    public Optional<user> findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
    //Autor: Ion Madan. Muestra por panralla los usuarios introducidos
    public void listUsers() {
        for (user u : users)
            System.out.println(u);
    }
    //Autor: Ion Madan. Guarda la lista de usuarios usando el archivo .json y si da algun error, lo muestra por pantalla
    private void save() {
        try (FileWriter writer = new FileWriter("users.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*Autor: Ion Madan. Lee el archivo .json y lo convierte en una lista de usuarios si el archivo no existe o da error, crea una
      lista vacía*/
    private void load() {
        try (FileReader reader = new FileReader("users.json")) {
            Type listType = new TypeToken<ArrayList<user>>(){}.getType();
            users = gson.fromJson(reader, listType);
            if (users == null) users = new ArrayList<>();
        } catch (IOException e) {
            users = new ArrayList<>();
        }
    }
}
