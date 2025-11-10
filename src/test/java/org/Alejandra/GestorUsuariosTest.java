package org.Alejandra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        GestorUsuarios manager = new GestorUsuarios();
        Usuario user = new Usuario("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
