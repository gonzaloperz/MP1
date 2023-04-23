package ORIGEN.Factory;

import java.util.ArrayList;

import Controladores.Pantalla;
import ORIGEN.Armadura;
import ORIGEN.Vampiro;
import ORIGEN.Arma;

public class VampiroFactory extends PersonajeFactory {
    @Override
    public Vampiro crearPersonaje() {
        Vampiro vampiro = new Vampiro();
        vampiro.setNombre(Pantalla.pedircadena("Elige nombre"));
        vampiro.setHabilidad(Pantalla.pedircadena("Elige nombre habilidad"));
        vampiro.setAtqHab(Pantalla.pedirenteros("Valor ataque"));
        vampiro.setDefHab(Pantalla.pedirenteros("Valor defensa"));
        vampiro.setCosteHabilidad(Pantalla.pedirenteros("Valor coste"));
        vampiro.setPoder(Pantalla.pedirenteros("Poder"));
        vampiro.setOro(500);
        vampiro.setSalud(5);
        vampiro.setEdad(Pantalla.pedirenteros("Edad vampiro"));
        vampiro.setPuntosSange(Pantalla.pedirenteros("Puntos de sangre"));
        System.out.println("personaje creado");





        vampiro.setArmadura(new ArrayList<Armadura>());
        vampiro.setArmas(new ArrayList<Arma>());
        vampiro.setArmaduraActiva(new Armadura());
        vampiro.setArmasActivas(new ArrayList<Arma>());
    return vampiro;
    }

}
