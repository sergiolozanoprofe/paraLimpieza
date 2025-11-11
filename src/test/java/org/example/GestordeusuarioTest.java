package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestordeusuarioTest {

    @Test
    void testAddAndFindUser() {
        Gestordeusuario manager = new Gestordeusuario();
        user user = new user("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
