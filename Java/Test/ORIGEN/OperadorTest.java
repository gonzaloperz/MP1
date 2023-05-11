package ORIGEN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperadorTest {
    @Test
    void validardesafio() {
        Operador operador = new Operador();
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Desafio desafio = new Desafio(usuario1, usuario2, 5);

    }
}