package org.Ion_Madan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    void testAddAndFindUser() {
        UserManager manager = new UserManager();
        user user = new user("juan", "juan@Ion_Madan.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@Ion_Madan.com", manager.findUser("juan").get().getemail());
    }
}
