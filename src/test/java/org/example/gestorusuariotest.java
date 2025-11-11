package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class gestorusuariotest {

    @Test
    void testAddAndFindUser() {
        gestorusuario manager = new gestorusuario();
        usuario user = new usuario("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
