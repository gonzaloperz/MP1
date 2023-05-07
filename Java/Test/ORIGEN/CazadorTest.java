package ORIGEN;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CazadorTest {

    @Test
    void testcalcularAtaque() {
        List<Arma> listaarmas = new ArrayList<>();
        Arma arma = new Arma();
        arma.setModificadorAtc(1);
        listaarmas.add(arma);
        Cazador cazador = new Cazador();
        cazador.setVoluntad(1);
        cazador.setPoder(1);
        cazador.setAtqHab(1);
        cazador.setArmas((ArrayList<Arma>) listaarmas);
        cazador.setArmasActivas((ArrayList<Arma>) listaarmas);
        assertEquals(4, cazador.calcularAtaque());
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
        Cazador cazador = new Cazador();
        cazador.setArmas((ArrayList<Arma>) listaarmas);
        cazador.setArmasActivas((ArrayList<Arma>) listaarmas);
        cazador.setVoluntad(1);
        cazador.setPoder(1);
        cazador.setDefHab(1);
        cazador.setArmadura((ArrayList<Armadura>) listaarmaduras);
        cazador.setArmaduraActiva(armadura);
        assertEquals(4, cazador.calcularDefensa());
    }
}