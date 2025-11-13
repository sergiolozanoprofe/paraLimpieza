package org.joserodriguez;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Gestordeusuario {
 /** verifica automaticamente que cuando se añade un usuario al gestor luego se puede encontrar correctamente y su correo elecronico es el correcto*/
 /** @author JoseRodriguez */
    private Gson gson = new Gson();
    private List<usuario> usuarios = new ArrayList<>();

    public Gestordeusuario() {
        load();
    }

    public void addUser(usuario u) {
        if (u == null)
            return;
        usuarios.add(u);
        save();
    }

    public Optional<usuario> findUser(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public void listUsers() {
        for (usuario u : usuarios)
            System.out.println(u);
    }

    private void save() {
        try (FileWriter writer = new FileWriter(constante.ARCHIVO_USUARIOS)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            System.err.println(constante.ERROR_GUARDAR);
            e.printStackTrace();
        }
    }

    private void load() {
        try (FileReader reader = new FileReader(constante.ARCHIVO_USUARIOS)) {
            Type listType = new TypeToken<ArrayList<usuario>>(){}.getType();
            usuarios = gson.fromJson(reader, listType);
            if (usuarios == null) usuarios = new ArrayList<>();
        } catch (IOException e) {
            System.err.println(constante.ERROR_CARGAR);
            usuarios = new ArrayList<>();
        }
    }
}
