package ORIGEN.Factory;

import Controladores.Pantalla;
import ORIGEN.Armadura;
import ORIGEN.Licantropo;
import ORIGEN.Arma;

import java.util.ArrayList;


public class LicantropoFactory extends PersonajeFactory{

    @Override
    public Licantropo crearPersonaje() {
        Licantropo licantropo = new Licantropo();
        licantropo.setNombre(Pantalla.pedircadena("Elige nombre"));
        licantropo.setHabilidad(Pantalla.pedircadena("Elige nombre habilidad"));
        licantropo.setAtqHab(Pantalla.pedirenteros("Valor ataque"));
        licantropo.setDefHab(Pantalla.pedirenteros("Valor defensa"));
        licantropo.setCosteHabilidad(Pantalla.pedirenteros("Valor coste"));
        licantropo.setPoder(Pantalla.pedirenteros("Poder"));
        licantropo.setOro(500);
        licantropo.setSalud(5);

        licantropo.setRabia(Pantalla.pedirenteros("rabia inicial"));
        System.out.println("personaje creado");



        licantropo.setArmadura(new ArrayList<Armadura>());
        licantropo.setArmas(new ArrayList<Arma>());
        licantropo.setArmaduraActiva(new Armadura());
        licantropo.setArmasActivas(new ArrayList<Arma>());

        return licantropo;
    }
}
