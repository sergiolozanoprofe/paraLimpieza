package org.Jorge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    void testAddAndFindUser() {
        GestorUsuarios manager = new GestorUsuarios();
        Usuario user = new Usuario("juan", "juan@example.com");
        manager.agregarUsuario(user);

        assertTrue(manager.buscarUsuario("juan").isPresent());
        assertEquals("juan@example.com", manager.buscarUsuario("juan").get().getemail());
    }
}
