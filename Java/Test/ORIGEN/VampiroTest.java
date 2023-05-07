package ORIGEN;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VampiroTest {

    @Test
    void testcalcularAtaque() {
        List<Arma> listaarmas = new ArrayList<>();
        Arma arma = new Arma();
        arma.setModificadorAtc(1);
        listaarmas.add(arma);
        Vampiro vampiro = new Vampiro();
        vampiro.setPuntosSangre(5);
        vampiro.setPoder(1);
        vampiro.setAtqHab(1);
        vampiro.setArmas((ArrayList<Arma>) listaarmas);
        vampiro.setArmasActivas((ArrayList<Arma>) listaarmas);
        assertEquals(5, vampiro.calcularAtaque());
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
        Vampiro vampiro = new Vampiro();
        vampiro.setArmas((ArrayList<Arma>) listaarmas);
        vampiro.setArmasActivas((ArrayList<Arma>) listaarmas);
        vampiro.setPuntosSangre(5);
        vampiro.setPoder(1);
        vampiro.setDefHab(1);
        vampiro.setArmadura((ArrayList<Armadura>) listaarmaduras);
        vampiro.setArmaduraActiva(armadura);
        assertEquals(5, vampiro.calcularDefensa());
    }

    @Test
    void testsaludEsbirros() {
        Vampiro vampiro = new Vampiro();
        Ghoul ghoul = new Ghoul("test",1,1,"test");
        List<Esbirro> listaesbirros = new ArrayList<>();
        listaesbirros.add(ghoul);
        vampiro.setEsbirros((ArrayList<Esbirro>) listaesbirros);
        assertEquals(1, vampiro.saludEsbirros());
    }
}