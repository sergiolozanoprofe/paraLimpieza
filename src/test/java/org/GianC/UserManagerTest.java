package org.GianC;

import org.junit.jupiter.api.Test;

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
