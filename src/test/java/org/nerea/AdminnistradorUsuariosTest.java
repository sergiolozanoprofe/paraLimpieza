package org.nerea;

import org.junit.jupiter.api.Test;

public class AdminnistradorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        AdministratorUsurious manager = new AdministratorUsurious();
        Usuario Usuario = new Usuario("juan", "juan@example.com");
        manager.aniadirUsuario(Usuario);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
