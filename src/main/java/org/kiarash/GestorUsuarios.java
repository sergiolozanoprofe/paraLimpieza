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
import java.util.logging.Logger;

public class GestorUsuarios {
    private final Gson gson = new Gson();
    private List<Usuario> usuarios = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(GestorUsuarios.class.getName());

    public GestorUsuarios() {
        cargar();
    }

    public void añadirUsuario(Usuario usuario) {
        if (usuario == null) {
            LOGGER.warning("Intento de añadir usuario nulo");
            return;
        }
        usuarios.add(usuario);
        guardar();
        LOGGER.info("Usuario añadido: " + usuario.getNombreUsuario());
    }

    public Optional<Usuario> buscarUsuario(String nombreUsuario) {
        return usuarios.stream()
                .filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void guardar() {
        try (FileWriter escritor = new FileWriter(Constantes.ARCHIVO_USUARIOS)) {
            gson.toJson(usuarios, escritor);
        } catch (IOException e) {
            LOGGER.severe(Constantes.ERROR_ESCRITURA + ": " + e.getMessage());
        }
    }

    private void cargar() {
        try (FileReader lector = new FileReader(Constantes.ARCHIVO_USUARIOS)) {
            Type tipoLista = new TypeToken<ArrayList<Usuario>>(){}.getType();
            usuarios = gson.fromJson(lector, tipoLista);
            if (usuarios == null) usuarios = new ArrayList<>();
        } catch (IOException e) {
            LOGGER.info(Constantes.ERROR_LECTURA + ": " + e.getMessage());
            usuarios = new ArrayList<>();
        }
    }
}