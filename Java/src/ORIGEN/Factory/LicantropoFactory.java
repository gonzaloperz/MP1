package ORIGEN.Factory;

import Controladores.Pantalla;
import ORIGEN.Armadura;
import ORIGEN.Licantropo;
import ORIGEN.Arma;

import java.util.ArrayList;


public class LicantropoFactory extends PersonajeFactory{

    ArrayList<Arma> armasac = new ArrayList<>();
    ArrayList<Arma> armas = new ArrayList<>();

    ArrayList<Armadura> armaduras=  new ArrayList<Armadura>();

    @Override
    public Licantropo crearPersonaje() {
        Licantropo licantropo = new Licantropo();
        licantropo.setNombre(Pantalla.pedircadena("Elige nombre"));
        licantropo.setHabilidad(Pantalla.pedircadena("Elige nombre de don"));
        licantropo.setAtqHab(Pantalla.pedirenteros("Valor ataque"));
        licantropo.setDefHab(Pantalla.pedirenteros("Valor defensa"));
        licantropo.setCosteHabilidad(Pantalla.pedirenteros("Valor coste"));
        licantropo.setPoder(Pantalla.pedirenteros("Poder"));
        licantropo.setOro(500);
        licantropo.setSalud(5);
        licantropo.setRabia(0);
        Pantalla.imprimir("personaje creado");



        armas.add(armaDefault());//armas
        licantropo.setArmas(armas);

        armasac.add(armaDefault());//arma activa
        licantropo.setArmasActivas(armasac);


        armaduras.add(armaduraDefault());
        licantropo.setArmadura(armaduras);//armadura

        licantropo.setArmaduraActiva(armaduraDefault());//armadura activa

        return licantropo;
    }

    public Arma armaDefault(){
        Arma arma = new Arma();
        arma.setNombre("palo");
        arma.setEmpuñadura(1);
        arma.setModificadorAtc(1);
        arma.setModificadorDef(0);
        return arma;
    }

    public Armadura armaduraDefault(){
        Armadura nueva = new Armadura();
        nueva.setNombre("cota de malla");
        nueva.setModificadorAtc(1);
        nueva.setModificadorDef(1);
        return nueva;
    }
}
