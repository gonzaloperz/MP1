package Controladores;

import ORIGEN.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DesafiosControllerTest {

    @Test
    void testiniciarDesafio() throws IOException {
        Usuario usu1 = new Usuario();
        Usuario usu2 = new Usuario();
        List<Usuario> listausuarios = new ArrayList<>();
        usu1.setNombre("test1");
        usu1.setNickname("test1");
        Vampiro vampiro = new Vampiro();
        Vampiro vampiro2 = new Vampiro();
        vampiro.setPuntosSangre(50000);
        vampiro2.setPuntosSangre(0);
        vampiro.setPoder(50000);
        vampiro2.setPoder(0);
        vampiro.setAtqHab(50000);
        vampiro.setDefHab(50000);
        vampiro2.setAtqHab(0);
        vampiro2.setDefHab(0);
        Arma arma = new Arma();
        Arma arma2 = new Arma();
        arma.setModificadorAtc(50000);
        arma2.setModificadorAtc(0);
        List<Arma> armas = new ArrayList<>();
        List<Arma> armas2 = new ArrayList<>();
        armas.add(arma);
        armas2.add(arma2);
        Armadura armadura = new Armadura();
        Armadura armadura2 = new Armadura();
        armadura.setModificadorDef(5000000);
        armadura2.setModificadorDef(0);
        vampiro.setArmasActivas((ArrayList<Arma>) armas);
        vampiro2.setArmasActivas((ArrayList<Arma>) armas2);
        vampiro.setArmaduraActiva(armadura);
        vampiro2.setArmaduraActiva(armadura2);
        usu1.setNombre("test1.0");
        usu1.setNickname("test1.0");
        usu2.setNombre("test2.0");
        usu2.setNickname("test2.0");
        usu1.setPersonaje(vampiro);
        usu2.setPersonaje(vampiro2);
        listausuarios.add(usu1);
        listausuarios.add(usu2);
        Desafio desafio = new Desafio(usu1, usu2, 5);
        desafio.setUserUno(usu1);
        desafio.setUserDos(usu2);
        DesafiosController desafiosController = new DesafiosController();
        assertEquals(desafio, desafiosController.iniciarDesafio(desafio, listausuarios));
    }

    @Test
    void testmodificadorataque() {
        DesafiosController desafiosController = new DesafiosController();
        Usuario usu1 = new Usuario();
        Usuario usu2 = new Usuario();
        usu1.setNombre("test1.0");
        usu1.setNickname("test1.0");
        usu2.setNombre("test2.0");
        usu2.setNickname("test2.0");
        Vampiro vampiro = new Vampiro();
        Vampiro vampiro2 = new Vampiro();
        usu1.setPersonaje(vampiro);
        usu2.setPersonaje(vampiro2);
        Desafio desafio = new Desafio(usu1, usu2,5);
        desafio.setModificador(1);
        assertEquals(0, desafiosController.modificadorataque(desafio, vampiro));
    }

    @Test
    void testmodificadordefensa() {
        DesafiosController desafiosController = new DesafiosController();
        Usuario usu1 = new Usuario();
        Usuario usu2 = new Usuario();
        usu1.setNombre("test1.0");
        usu1.setNickname("test1.0");
        usu2.setNombre("test2.0");
        usu2.setNickname("test2.0");
        Vampiro vampiro = new Vampiro();
        Vampiro vampiro2 = new Vampiro();
        usu1.setPersonaje(vampiro);
        usu2.setPersonaje(vampiro2);
        Desafio desafio = new Desafio(usu1, usu2,5);
        desafio.setModificador(1);
        assertEquals(1, desafiosController.modificadordefensa(desafio, vampiro));
    }

    @Test
    void testpagarGanador() {
        DesafiosController desafiosController = new DesafiosController();
        Usuario usu1 = new Usuario();
        Usuario usu2 = new Usuario();
        usu1.setNombre("test1.0");
        usu1.setNickname("test1.0");
        usu2.setNombre("test2.0");
        usu2.setNickname("test2.0");
        Vampiro vampiro = new Vampiro();
        Vampiro vampiro2 = new Vampiro();
        vampiro.setOro(5);
        vampiro2.setOro(10);
        usu1.setPersonaje(vampiro);
        usu2.setPersonaje(vampiro2);
        Desafio desafio = new Desafio(usu1, usu2,5);
        desafio.setOroApostado(5);
        desafio.setGanador(2);
        List<Usuario> listausuarios = new ArrayList<>();
        listausuarios.add(usu1);
        listausuarios.add(usu2);
        desafiosController.pagarGanador(desafio, listausuarios);
        assertEquals(0, usu1.getPersonaje().getOro());
    }

    @Test
    void testpotencialAtaque() {
        DesafiosController desafiosController = new DesafiosController();
        assertTrue(desafiosController.potencialAtaque(5) >= 0);
    }

    @Test
    void testpotencialDefensa() {
        DesafiosController desafiosController = new DesafiosController();
        assertTrue(desafiosController.potencialDefensa(5) >= 0);
    }
}