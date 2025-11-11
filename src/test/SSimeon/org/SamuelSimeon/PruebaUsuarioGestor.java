package org.SamuelSimeon;

import org.junit.jupiter.api.Test;

public class PruebaUsuarioGestor {

    @Test
    void testAddAndFindUser() {
        UserManager manager = new UserManager();
        org.SamuelSimeon.usuario user = new org.SamuelSimeon.usuario("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
