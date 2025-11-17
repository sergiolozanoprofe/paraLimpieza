package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
/**
 * Clase que gestiona una lista de usuarios.
 * Permite añadir, buscar y listar usuarios, así como
 * guardar y cargar la información desde un archivo JSON.
 * @author Alejandro Herrero
 */
public class UserManager {

    private Gson gson = new Gson();
    private List<user> users = new ArrayList<>();
    public UserManager() {
        load();
    }
    /**
     * Añade un usuario a la lista y guarda los cambios
     */
    public void addUser(user u) {
        if (u == null)
            return;
        users.add(u);
        save();
    }
    /**
     * Busca un usuario por su nombre
     */
    public Optional<user> findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
    /**
     * Muestra todos los usuarios por consola
     */
    public void listUsers() {
        for (user u : users)
            System.out.println(u);
    }
    /**
     * Guarda la lista de usuarios en un archivo JSON
     */
    private void save() {
        try (FileWriter writer = new FileWriter("users.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Carga los usuarios desde el archivo JSON
     */
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
