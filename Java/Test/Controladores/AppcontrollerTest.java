package Controladores;

import ORIGEN.Operador;
import ORIGEN.Usuario;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;


class AppcontrollerTest {
    @Test
    void testcargarDatos() throws IOException, ClassNotFoundException {
        Appcontroller appcontroller = new Appcontroller();
        appcontroller.cargarDatos();
        Operador operador = new Operador();
        operador.setNickname("OPERADOR");
        operador.setNombre("OPERADOR");
        operador.setContrasena("OPERADOR");
        assertTrue(appcontroller.getUsuarios().get(0).getNickname().equals("OPERADOR"));
    }

    @Test
    void guardarDatos() {
    }

    @Test
    void guardarUsuarios() {
    }

    @Test
    void menu() {
    }

    @Test
    void start() {
    }

    @Test
    void ranking() {
    }

    @Test
    void logo() {
    }
}