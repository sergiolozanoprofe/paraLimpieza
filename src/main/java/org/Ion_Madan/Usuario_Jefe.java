package org.Ion_Madan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Usuario_Jefe {

    private Gson gson = new Gson();
    private List<usuario> usuarios = new ArrayList<>();

    public Usuario_Jefe() {
        load();
    }

    public void addUser(usuario u) {
        if (u == null)
            return;
        usuarios.add(u);
        save();
    }

    public Optional<usuario> findUser(String nombre_usuario) {
        return usuarios.stream()
                .filter(u -> u.getNombre_usuario().equalsIgnoreCase(nombre_usuario))
                .findFirst();
    }

    public void listUsers() {
        for (usuario u : usuarios)
            System.out.println(u);
    }

    private void save() {
        try (FileWriter writer = new FileWriter("usuarios.json")) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        try (FileReader reader = new FileReader("usuarios.json")) {
            Type listType = new TypeToken<ArrayList<usuario>>(){}.getType();
            usuarios = gson.fromJson(reader, listType);
            if (usuarios == null) usuarios = new ArrayList<>();
        } catch (IOException e) {
            usuarios = new ArrayList<>();
        }
    }
}
