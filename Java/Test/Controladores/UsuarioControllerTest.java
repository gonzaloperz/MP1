package Controladores;

import ORIGEN.Usuario;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioControllerTest {
    @Test
    void testmenuUsuario(){
    }
    @Test
    void testseleccionarUsuario() {
        UsuarioController ucon = new UsuarioController();
        List<Usuario> listausuario = new ArrayList<>();
        Usuario usu = new Usuario();
        usu.setNickname("test");
        usu.setNombre("test");
        listausuario.add(usu);
        assertEquals(usu, ucon.seleccionarUsuario(listausuario, "test"));
    }

    @Test
    void verRanking() {
    }

    @Test
    void menuUsuario() {
    }

    @Test
    void menuOperador() {
    }

    @Test
    void verCombate() {
    }

    @Test
    void desafiar() {
    }
}