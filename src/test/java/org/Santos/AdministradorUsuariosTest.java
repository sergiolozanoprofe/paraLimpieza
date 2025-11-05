package org.Santos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        AdministradorUsuarios manager = new AdministradorUsuarios();
        Usuario Usuario = new Usuario("juan", "juan@example.com");
        manager.addUser(Usuario);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().obtenerMail());
    }
}
