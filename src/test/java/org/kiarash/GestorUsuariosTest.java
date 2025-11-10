package org.kiarash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorUsuariosTest {

    @Test
    void testAñadirYBuscarUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        Usuario usuario = new Usuario("kiarash", "kiarash@kiarash.com");
        gestor.añadirUsuario(usuario);

        assertTrue(gestor.buscarUsuario("kiarash").isPresent());
        assertEquals("kiarash@kiarash.com", gestor.buscarUsuario("kiarash").get().getCorreo());
    }
}