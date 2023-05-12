package ORIGEN.Factory;

import ORIGEN.Arma;
import ORIGEN.Armadura;
import ORIGEN.Licantropo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicantropoFactoryTest {
    @Test
    void testarmaDefault() {
        LicantropoFactory licantropoFactory = new LicantropoFactory();
        Arma arma = new Arma();
        arma.setNombre("palo");
        assertEquals(arma.getNombre(), licantropoFactory.armaDefault().getNombre());
    }

    @Test
    void testarmaduraDefault() {
        LicantropoFactory licantropoFactory = new LicantropoFactory();
        Armadura armadura = new Armadura();
        armadura.setNombre("cota de malla");
        assertEquals(armadura.getNombre(), licantropoFactory.armaduraDefault().getNombre());
    }
}