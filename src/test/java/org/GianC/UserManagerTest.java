package org.GianC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Autor: Gianfranco Castelli
 * Esta clase se encarga de asignar un administrador de usuarios
 */
public class UserManagerTest {

    @Test
    void testAddAndFindUser() {
        UserManager manager = new UserManager();
        user user = new user("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
