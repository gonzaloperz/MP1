package ORIGEN.Factory;

import Controladores.Pantalla;
import ORIGEN.Armadura;
import ORIGEN.Cazador;
import  ORIGEN.Arma;

import java.util.ArrayList;


public class CazadorFactory extends PersonajeFactory{

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
        System.out.println("personaje creado");




        cazador.setArmadura(new ArrayList<Armadura>());
        cazador.setArmas(new ArrayList<Arma>());
        cazador.setArmaduraActiva(new Armadura());
        cazador.setArmasActivas(new ArrayList<Arma>());

        return cazador;
    }
}
