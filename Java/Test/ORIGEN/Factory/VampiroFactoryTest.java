package ORIGEN.Factory;

import ORIGEN.Arma;
import ORIGEN.Armadura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VampiroFactoryTest {

    @Test
    void testarmaDefault() {
        VampiroFactory vampiroFactory = new VampiroFactory();
        Arma arma = new Arma();
        arma.setNombre("Palo");
        assertEquals(arma.getNombre(), vampiroFactory.armaDefault().getNombre());
    }

    @Test
    void testarmaduraDefault() {
        VampiroFactory vampiroFactory = new VampiroFactory();
        Armadura armadura = new Armadura();
        armadura.setNombre("Cota de malla");
        assertEquals(armadura.getNombre(), vampiroFactory.armaduraDefault().getNombre());
    }
}