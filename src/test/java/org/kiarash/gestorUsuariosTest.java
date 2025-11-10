package org.kiarash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class gestorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        GestorUsuarios manager = new GestorUsuarios();
        usuario usuario = new usuario("kiarash", "kiarash@kiarash.com");
        manager.addUser(usuario);

        assertTrue(manager.findUser("kiarash").isPresent());
        assertEquals("kiarash@kiarash.com", manager.findUser("kiarash").get().getemail());
    }
}