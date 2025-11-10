package org.example;

import org.mikerincones.GestorUsuarios;
import org.mikerincones.usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        GestorUsuarios manager = new GestorUsuarios();
        usuario usuario = new usuario("juan", "juan@example.com");
        manager.addUser(usuario);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
