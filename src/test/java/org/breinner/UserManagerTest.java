package org.breinner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    void testAddAndFindUser() {
        UserManager manager = new UserManager();
        user user = new user("juan", "juan@breinner.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@breinner.com", manager.findUser("juan").get().getemail());
    }
}
