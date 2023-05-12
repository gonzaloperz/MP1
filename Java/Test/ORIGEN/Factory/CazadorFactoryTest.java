package ORIGEN.Factory;

import ORIGEN.Arma;
import ORIGEN.Armadura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CazadorFactoryTest {

    @Test
    void testarmaDefault() {
        CazadorFactory cazadorFactory = new CazadorFactory();
        Arma arma = new Arma();
        arma.setNombre("palo");
        assertEquals(arma.getNombre(), cazadorFactory.armaDefault().getNombre());
    }

    @Test
    void testarmaduraDefault() {
        CazadorFactory cazadorFactory = new CazadorFactory();
        Armadura armadura = new Armadura();
        armadura.setNombre("cota de malla");
        assertEquals(armadura.getNombre(), cazadorFactory.armaduraDefault().getNombre());
    }
}