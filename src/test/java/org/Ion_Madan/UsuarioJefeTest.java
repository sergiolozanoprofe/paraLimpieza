package org.Ion_Madan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioJefeTest {

    @Test
    void testAddAndFindUser() {
        Usuario_Jefe manager = new Usuario_Jefe();
        usuario usuario = new usuario("juan", "juan@Ion_Madan.com");
        manager.addUser(usuario);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@Ion_Madan.com", manager.findUser("juan").get().getemail());
    }
}
