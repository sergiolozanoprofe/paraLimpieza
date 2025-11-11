package org.tpineda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioGestrorPrueba {

    @Test
    void testAddAndFindUser() {
        UsuarioGestor manager = new UsuarioGestor();
        usuario user = new usuario("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().email());
    }
}
