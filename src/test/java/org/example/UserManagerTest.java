package org.example;

import org.DEYVIDGAMBOAOGEDA.USUARIOGERENTE;
import org.DEYVIDGAMBOAOGEDA.USUARIO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    void testAddAndFindUser() {
        USUARIOGERENTE manager = new USUARIOGERENTE();
        USUARIO user = new USUARIO("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
