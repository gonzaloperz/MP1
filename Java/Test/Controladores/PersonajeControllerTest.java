package Controladores;

import ORIGEN.Vampiro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeControllerTest {

    @Test
    void testeditarArma() {
        Vampiro vampiro = new Vampiro();
        PersonajeController personajeController = new PersonajeController();
        assertEquals(vampiro, personajeController.editarArma(vampiro));
    }

    @Test
    void testeditarArmadura() {
        Vampiro vampiro = new Vampiro();
        PersonajeController personajeController = new PersonajeController();
        assertEquals(vampiro, personajeController.editarArmadura(vampiro));
    }

    @Test
    void testeditarDebilidad() {
        Vampiro vampiro = new Vampiro();
        PersonajeController personajeController = new PersonajeController();
        assertEquals(vampiro, personajeController.editarDebilidad(vampiro));
    }

    @Test
    void editarFortaleza() {
        Vampiro vampiro = new Vampiro();
        PersonajeController personajeController = new PersonajeController();
        assertEquals(vampiro, personajeController.editarFortaleza(vampiro));
    }
}