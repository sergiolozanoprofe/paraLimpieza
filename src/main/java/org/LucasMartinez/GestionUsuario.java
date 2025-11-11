package org.LucasMartinez;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class GestionUsuario {

    private Gson gson = new Gson();
    private List<Usuario> users = new ArrayList<>();

    public GestionUsuario() {
        load();
    }

    public void addUser(Usuario u) {
        if (u == null)
            return;
        users.add(u);
        save();
    }

    public Optional<Usuario> findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public void listUsers() {
        for (Usuario u : users)
            System.out.println(u);
    }

    private void save() {
        try (FileWriter writer = new FileWriter("users.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        try (FileReader reader = new FileReader("users.json")) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            users = gson.fromJson(reader, listType);
            if (users == null) users = new ArrayList<>();
        } catch (IOException e) {
            users = new ArrayList<>();
        }
    }
}
