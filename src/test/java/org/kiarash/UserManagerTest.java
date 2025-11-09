package org.kiarash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Test
    void probarAgregarYEncontrarUsuario() {
        UserManager gestor = new UserManager();
        Usuario usuario = new Usuario("kiarash", "kiarash.fst@gmail.com");
        gestor.agregarUsuario(usuario);

        assertTrue(gestor.encontrarUsuario("kiarash").isPresent());
        assertEquals("kiarash.fst@gmail.com", gestor.encontrarUsuario("kiarash").get().getEmail());
    }
}
