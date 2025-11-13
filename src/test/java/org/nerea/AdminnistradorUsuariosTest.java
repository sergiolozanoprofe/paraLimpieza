package org.nerea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminnistradorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        AdministradorUsurios manager = new AdministradorUsurios();
        Usuario Usuario = new Usuario("juan", "juan@example.com");
        manager.aniadirUsuario(Usuario);

        assertTrue(manager.buscarUsuario("juan").isPresent());
        assertEquals("juan@example.com", manager.buscarUsuario("juan").get().correoElectronico());
    }
}
