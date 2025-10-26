package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManager {
    private static final String FILE = "users.json";
    private final Gson gson = new Gson();
    private List<User> users = new ArrayList<>();

    public UserManager() {
        load();
    }

    public void addUser(User user) {
        users.add(user);
        save();
    }

    public Optional<User> findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private void save() {
        try (FileWriter writer = new FileWriter(FILE)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.err.println("Error guardando usuarios: " + e.getMessage());
        }
    }

    private void load() {
        try (FileReader reader = new FileReader(FILE)) {
            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            users = gson.fromJson(reader, listType);
            if (users == null) users = new ArrayList<>();
        } catch (IOException e) {
            users = new ArrayList<>();
        }
    }
}
