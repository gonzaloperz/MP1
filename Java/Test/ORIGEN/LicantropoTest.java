package ORIGEN;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LicantropoTest {

    @Test
    void testcalcularAtaque() {
        List<Arma> listaarmas = new ArrayList<>();
        Arma arma = new Arma();
        arma.setModificadorAtc(1);
        listaarmas.add(arma);
        Licantropo licantropo = new Licantropo();
        licantropo.setRabia(3);
        licantropo.setPoder(1);
        licantropo.setAtqHab(1);
        licantropo.setCosteHabilidad(1);
        licantropo.setArmas((ArrayList<Arma>) listaarmas);
        licantropo.setArmasActivas((ArrayList<Arma>) listaarmas);
        assertEquals(3, licantropo.calcularAtaque());
    }

    @Test
    void testcalcularDefensa() {
        List<Arma> listaarmas = new ArrayList<>();
        Arma arma = new Arma();
        arma.setModificadorAtc(1);
        listaarmas.add(arma);
        List<Armadura> listaarmaduras = new ArrayList<>();
        Armadura armadura = new Armadura();
        armadura.setModificadorDef(1);
        listaarmaduras.add(armadura);
        Licantropo licantropo = new Licantropo();
        licantropo.setArmas((ArrayList<Arma>) listaarmas);
        licantropo.setArmasActivas((ArrayList<Arma>) listaarmas);
        licantropo.setRabia(3);
        licantropo.setPoder(1);
        licantropo.setDefHab(1);
        licantropo.setArmadura((ArrayList<Armadura>) listaarmaduras);
        licantropo.setArmaduraActiva(armadura);
        assertEquals(3, licantropo.calcularDefensa());
    }

    @Test
    void testsaludEsbirros() {
        Licantropo licantropo = new Licantropo();
        Ghoul ghoul = new Ghoul("test",1,1,"test");
        List<Esbirro> listaesbirros = new ArrayList<>();
        listaesbirros.add(ghoul);
        licantropo.setEsbirros((ArrayList<Esbirro>) listaesbirros);
        assertEquals(1, licantropo.saludEsbirros());
    }
}