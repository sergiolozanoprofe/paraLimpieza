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

/**
 * Gestiona operaciones de usuarios incluyendo añadir, buscar, listar y persistir usuarios.
 * Usa archivo JSON para almacenamiento de datos y librería Gson para serialización.
 *
 * @author Kiarash (autor original)
 * @author [Tu Nombre] - ¡Reemplaza con tu nombre real!
 * @version 1.0
 */
public class GestorUsuarios {
    // Instancia de Gson para serialización/deserialización JSON
    private final Gson gson = new Gson();

    // Lista para mantener todos los usuarios en memoria
    private List<Usuario> usuarios = new ArrayList<>();

    // Logger para rastrear operaciones y errores
    private static final Logger LOGGER = Logger.getLogger(GestorUsuarios.class.getName());

    /**
     * Constructor que inicializa el gestor de usuarios y carga usuarios existentes del archivo.
     */
    public GestorUsuarios() {
        cargar(); // Carga usuarios desde archivo JSON al iniciar
    }

    /**
     * Añade un nuevo usuario al sistema y persiste en el archivo.
     *
     * @param usuario el objeto Usuario a añadir (no puede ser null)
     */
    public void añadirUsuario(Usuario usuario) {
        if (usuario == null) {
            LOGGER.warning("Intento de añadir usuario nulo");
            return;
        }
        usuarios.add(usuario);
        guardar(); // Guarda cambios en el archivo
        LOGGER.info("Usuario añadido: " + usuario.getNombreUsuario());
    }

    /**
     * Busca un usuario por nombre de usuario (no sensible a mayúsculas/minúsculas).
     *
     * @param nombreUsuario el nombre de usuario a buscar
     * @return Optional conteniendo el usuario si se encuentra, Optional vacío en caso contrario
     */
    public Optional<Usuario> buscarUsuario(String nombreUsuario) {
        return usuarios.stream()
                .filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    /**
     * Muestra todos los usuarios del sistema en la consola.
     * Muestra mensaje si no hay usuarios registrados.
     */
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    /**
     * Guarda la lista actual de usuarios en archivo JSON.
     * Usa Gson para serialización y maneja excepciones de E/S.
     */
    private void guardar() {
        try (FileWriter escritor = new FileWriter(Constantes.ARCHIVO_USUARIOS)) {
            gson.toJson(usuarios, escritor);
        } catch (IOException e) {
            LOGGER.severe(Constantes.ERROR_ESCRITURA + ": " + e.getMessage());
        }
    }

    /**
     * Carga usuarios desde archivo JSON a memoria.
     * Crea lista vacía si el archivo no existe o tiene errores.
     */
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