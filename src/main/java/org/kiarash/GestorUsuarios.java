package org.kiarash;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorUsuarios {
    private Gson gson = new Gson();
    private List<Usuario> usuario = new ArrayList<>();

    public GestorUsuarios() {
        cargar();
    }

    public void añadirUsuario(usuario usuario) {
        if (usuario == null) return;
        usuario.add(usuario);
        guardar();
    }

    public Optional<Usuario> buscarUsuario(String nombreUsuario) {
        return usuarios.stream()
                .filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void guardar() {
        try (FileWriter escritor = new FileWriter(Constantes.ARCHIVO_USUARIOS)) {
            gson.toJson(usuarios, escritor);
        } catch (IOException e) {
            System.err.println(Constantes.ERROR_ESCRITURA);
        }
    }

    private void cargar() {
        try (FileReader lector = new FileReader(Constantes.ARCHIVO_USUARIOS)) {
            Type tipoLista = new TypeToken<ArrayList<Usuario>>(){}.getType();
            usuarios = gson.fromJson(lector, tipoLista);
            if (usuarios == null) usuarios = new ArrayList<>();
        } catch (IOException e) {
            usuarios = new ArrayList<>();
        }
    }
}