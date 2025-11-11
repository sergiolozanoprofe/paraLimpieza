package org.breinner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebaAdministradorDeUsuarios {

    @Test
    void testAddAndFindUser() {
        AdministradorDeUsuarios manager = new AdministradorDeUsuarios();
        Usuario user = new Usuario("juan", "juan@breinner.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@breinner.com", manager.findUser("juan").get().getemail());
    }
}
