package org.kiarash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Remove 'public' - use package-private visibility
class GestorUsuariosTest {

    @Test
        // Remove 'public' - use package-private visibility
    void testAñadirYBuscarUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        Usuario usuario = new Usuario("kiarash", "kiarash@kiarash.com");
        gestor.añadirUsuario(usuario);

        assertTrue(gestor.buscarUsuario("kiarash").isPresent());
        assertEquals("kiarash@kiarash.com", gestor.buscarUsuario("kiarash").get().getCorreo());
    }

    @Test
        // You can add more test methods without 'public'
    void testBuscarUsuarioNoExistente() {
        GestorUsuarios gestor = new GestorUsuarios();
        assertFalse(gestor.buscarUsuario("noexiste").isPresent());
    }

    @Test
    void testAñadirUsuarioNulo() {
        GestorUsuarios gestor = new GestorUsuarios();
        // This should not throw an exception
        gestor.añadirUsuario(null);
        assertFalse(gestor.buscarUsuario("kiarash").isPresent());
    }
}