package org.imadan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioJefeTest {

    @Test
    void testAddAndFindUser() {
        usuariojefe manager = new usuariojefe();
        usuario usuario = new usuario("juan", "juan@imadan.com");
        manager.addUser(usuario);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@imadan.com", manager.findUser("juan").get().getemail());
    }
}
