package org.Alejandra;

import org.junit.jupiter.api.Test;
/** Este código verifica automaticamente que: cuando se añade un usuario al gestor, luego se puede encontrar correctamente, y su correo es el correcto.*/
/** @author Alejandra*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorUsuariosTest {

    @Test
    void testAddAndFindUser() {
        GestorUsuarios manager = new GestorUsuarios();
        Usuario user = new Usuario("juan", "juan@example.com");
        manager.addUser(user);

        assertTrue(manager.findUser("juan").isPresent());
        assertEquals("juan@example.com", manager.findUser("juan").get().getemail());
    }
}
