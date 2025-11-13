package org.example;
/** Comentario: verifica automaticamente cuando se añade un usuario al gestor lugo se pueda encontrar correctamente y el correo sea correcto**/
/** @author Marco**/
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class GestorUsuarios {

    private Gson gson = new Gson();
    private List<Usuario> Usuarios = new ArrayList<>();

    public GestorUsuarios() {
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
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public void listUsers() {
        for (Usuario u : Usuarios)
            System.out.println(u);
    }

    private void save() {
        try (FileWriter writer = new FileWriter(Constantes.ARCHIVO_USUARIOS)) {
            gson.toJson(Usuarios, writer);
        } catch (IOException e) {
            System.err.println(Constantes.ERROR_ESCRITURA);
            e.printStackTrace();
        }
    }

    private void load() {
        try (FileReader reader = new FileReader(Constantes.ARCHIVO_USUARIOS)) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            Usuarios = gson.fromJson(reader, listType);
            if (Usuarios == null) Usuarios = new ArrayList<>();
        } catch (IOException e) {
            System.err.println(Constantes.ERROR_LECTURA);
            Usuarios = new ArrayList<>();
        }
    }
}
