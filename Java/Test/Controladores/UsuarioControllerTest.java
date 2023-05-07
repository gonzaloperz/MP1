package Controladores;

import ORIGEN.Desafio;
import ORIGEN.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


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