package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/*
Es la clase intermedia entre el main y la de user. Se encarga de ejecutar las acciones segun lo que haya elegido el usario en la clase main.
conectandose con la clase user para poder operar.
* */

public class UserManager {

    private Gson gson = new Gson();
    private List<user> users = new ArrayList<>();

    public UserManager() {
        load();
    }


    /*
    Ejecuta parte de la funcion de anadir usuario, en caso de que no introduzca un valor, devuelve un aviso de que esta vacio. y sino lo almacena.
    * */
    public void addUser(user u) {
        if (u == null)
            return;
        users.add(u);
        save();
    }

    /*
    * ejecuta la funcion de buscar usuarios.
    * */
    public Optional<user> findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    /*
    * ejecuta la funcion de listar usuarios
    * */

    public void listUsers() {
        for (user u : users)
            System.out.println(u);
    }

    /*
    * Ejecuta la funcion de guardar
    * */

    private void save() {
        try (FileWriter writer = new FileWriter("users.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
