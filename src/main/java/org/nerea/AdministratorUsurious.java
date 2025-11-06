package org.nerea;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class AdministratorUsurious {

    private final Gson gson = new Gson();
    private List<Usuario> Usuarios = new ArrayList<>();

    public AdministratorUsurious() {
        carga();
    }

    public void aniadirUsuario(Usuario u) {
        if (u == null)
            return;
        Usuarios.add(u);
        guardar();
    }

    public Optional<Usuario> buscarUsuario(String nombreUsuario) {
        return Usuarios.stream()
                .filter(u -> u.nombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public void listaUsuarios() {
        for (Usuario u : Usuarios)
            System.out.println(u);
    }

    private void guardar() {
        try (FileWriter writer = new FileWriter("Usuarios.json")) {
            gson.toJson(Usuarios, writer);
        } catch (IOException ignored) {

        }
    }

    private void carga() {
        try (FileReader reader = new FileReader("Usuarios.json")) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            Usuarios = gson.fromJson(reader, listType);
            if (Usuarios == null) Usuarios = new ArrayList<>();
        } catch (IOException e) {
            Usuarios = new ArrayList<>();
        }
    }
}
