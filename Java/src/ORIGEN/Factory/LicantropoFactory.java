package ORIGEN.Factory;

import ORIGEN.Licantropo;
import ORIGEN.Personaje;

import java.util.ArrayList;

public class LicantropoFactory extends PersonajeFactory{

    @Override
    public Licantropo crearPersonaje() {
        Licantropo licantropo = new Licantropo();
        System.out.println("Elige nombre: ");
        licantropo.setNombre(scanner.nextLine());
        System.out.println("Elige Habilidad: ");
        licantropo.setHabilidad(scanner.nextLine());
        System.out.println("valor ataque: ");
        licantropo.setAtqHab((Integer.parseInt(scanner.nextLine())));
        System.out.println("valor ataque: ");
        licantropo.setDefHab((Integer.parseInt(scanner.nextLine())));
        System.out.println("coste habilidad: ");
        licantropo.setCosteHabilidad((Integer.parseInt(scanner.nextLine())));
        System.out.println("poder del personaje: ");
        licantropo.setPoder((Integer.parseInt(scanner.nextLine())));
        licantropo.setOro(500);
        licantropo.setSalud(5);
        System.out.println("rabia inicial");
        licantropo.setRabia((Integer.parseInt(scanner.nextLine())));



        licantropo.setArmadura(new ArrayList<Armadura>());
        licantropo.setArmas(new ArrayList<Arma>());
        licantropo.setArmaduraActiva(new Armadura());
        licantropo.setArmasActivas(new ArrayList<Arma>());

        return licantropo;
    }
}
