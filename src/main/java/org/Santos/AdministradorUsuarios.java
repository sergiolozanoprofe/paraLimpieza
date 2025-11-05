package org.Santos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class AdministradorUsuarios {

    private Gson gson = new Gson();
    private List<Usuario> Usuarios = new ArrayList<>();

    public AdministradorUsuarios() {
        load();
    }

    public void addUser(Usuario u) {
        if (u == null)
            return;
        Usuarios.add(u);
        save();
    }

    public Optional<Usuario> findUser(String username) {
        return Usuarios.stream()
                .filter(u -> u.obtenerNombre().equalsIgnoreCase(username))
                .findFirst();
    }

    public void listUsers() {
        for (Usuario u : Usuarios)
            System.out.println(u);
    }

    private void save() {
        try (FileWriter writer = new FileWriter("Usuarios.json")) {
            gson.toJson(Usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        try (FileReader reader = new FileReader("Usuarios.json")) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            Usuarios = gson.fromJson(reader, listType);
            if (Usuarios == null) Usuarios = new ArrayList<>();
        } catch (IOException e) {
            Usuarios = new ArrayList<>();
        }
    }
}
