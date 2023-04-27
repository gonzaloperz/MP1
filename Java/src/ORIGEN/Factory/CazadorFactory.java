package ORIGEN.Factory;

import Controladores.Pantalla;
import ORIGEN.Armadura;
import ORIGEN.Cazador;
import  ORIGEN.Arma;

import java.util.ArrayList;


public class CazadorFactory extends PersonajeFactory{

    ArrayList<Arma> armasac = new ArrayList<>();
    ArrayList<Arma> armas = new ArrayList<>();

    ArrayList<Armadura> armaduras=  new ArrayList<Armadura>();

    @Override
    public Cazador crearPersonaje() {
        Cazador cazador = new Cazador();
        cazador.setNombre(Pantalla.pedircadena("Elige nombre"));
        cazador.setHabilidad(Pantalla.pedircadena("Elige nombre habilidad"));
        cazador.setAtqHab(Pantalla.pedirenteros("Valor ataque"));
        cazador.setDefHab(Pantalla.pedirenteros("Valor defensa"));
        cazador.setCosteHabilidad(Pantalla.pedirenteros("Valor coste"));
        cazador.setPoder(Pantalla.pedirenteros("Poder"));
        cazador.setOro(500);
        cazador.setSalud(5);
        cazador.setVoluntad(3);
        Pantalla.imprimir("personaje creado");


        armas.add(armaDefault());//armas
        cazador.setArmas(armas);

        armasac.add(armaDefault());//arma activa
        cazador.setArmasActivas(armasac);


        armaduras.add(armaduraDefault());
        cazador.setArmadura(armaduras);//armadura

        cazador.setArmaduraActiva(armaduraDefault());//armadura activa




        return cazador;
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
