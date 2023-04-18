package ORIGEN.Factory;

import ORIGEN.Cazador;

import java.util.ArrayList;

public class CazadorFactory extends PersonajeFactory{
    @Override
    public Cazador crearPersonaje() {
        Cazador cazador = new Cazador();
        System.out.println("Elige nombre: ");
        cazador.setNombre(scanner.nextLine());
        System.out.println("Elige Habilidad: ");
        cazador.setHabilidad(scanner.nextLine());
        System.out.println("valor ataque: ");
        cazador.setAtqHab((Integer.parseInt(scanner.nextLine())));
        System.out.println("valor ataque: ");
        cazador.setDefHab((Integer.parseInt(scanner.nextLine())));
        System.out.println("coste habilidad: ");
        cazador.setCosteHabilidad((Integer.parseInt(scanner.nextLine())));
        System.out.println("poder del personaje: ");
        cazador.setPoder((Integer.parseInt(scanner.nextLine())));
        cazador.setOro(500);
        cazador.setSalud(5);
        cazador.setVoluntad(3);




        cazador.setArmadura(new ArrayList<Armadura>());
        cazador.setArmas(new ArrayList<Arma>());
        cazador.setArmaduraActiva(new Armadura());
        cazador.setArmasActivas(new ArrayList<Arma>());

        return cazador;
    }
}
