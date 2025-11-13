package org.nerea;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 *Esta es la clase administrar usuarios, aqui tenemos los metodos añadir usuario,
 * buscar usuario,listar usuario, guardar usuario y cargar usuarios
 */

public class AdministradorUsurios {
    private final Gson gson = new Gson();
    /**
     * aqui tenemos una lista usuario, las listas sirven para no repetir nombre de usuario y que sean todos unicos
     */
    private List<Usuario> Usuarios = new ArrayList<>();

    /**
     * este metodo carga usuarios, dentro tiene el metodo carga
     */
    public AdministradorUsurios() {
        carga();
    }

    /**
     * este metodo añade usuarios. Dice que si usuario es nulo (no existe)
     * pues que entonces es un usuario valido y que se añada y lo guarde, para ello llama al metodo guardar de esta misma clase
     * @param u
     */
    public void aniadirUsuario(Usuario u) {
        if (u == null)
            return;
        Usuarios.add(u);
        guardar();
    }

    /**
     * este metodo busca usuarios. Metes el nombre de tu usuario independientemente
     * de si hay mayusculas o no en tu nombre (no es case sensitive)
     * @param nombreUsuario
     * @return
     */
    public Optional<Usuario> buscarUsuario(String nombreUsuario) {
        return Usuarios.stream()
                .filter(u -> u.nombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    /**
     * este metodo lista a los usuarios. Si el usuario exite pues lo imprime
     */
    public void listaUsuarios() {
        for (Usuario u : Usuarios)
            System.out.println(u);
    }

    /**
     * este metodo guarda al usuario
     */
    private void guardar() {
        try (FileWriter writer = new FileWriter("Usuarios.json")) {
            gson.toJson(Usuarios, writer);
        } catch (IOException ignored) {

        }
    }

    /**
     * este metodo carga al usuario
     */
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
