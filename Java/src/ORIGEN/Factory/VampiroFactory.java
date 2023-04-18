package ORIGEN.Factory;

import java.util.ArrayList;
import java.util.Scanner;

import ORIGEN.Armadura;
import ORIGEN.Vampiro;
import ORIGEN.Arma;

public class VampiroFactory extends PersonajeFactory {

    Scanner scanner = new Scanner(System.in);
    @Override
    public Vampiro crearPersonaje() {
        Vampiro vampiro = new Vampiro();
        System.out.println("Elige nombre: ");
        vampiro.setNombre(scanner.nextLine());
        System.out.println("Elige Habilidad: ");
        vampiro.setHabilidad(scanner.nextLine());
        System.out.println("valor ataque: ");
        vampiro.setAtqHab((Integer.parseInt(scanner.nextLine())));
        System.out.println("valor ataque: ");
        vampiro.setDefHab((Integer.parseInt(scanner.nextLine())));
        System.out.println("coste habilidad: ");
        vampiro.setCosteHabilidad((Integer.parseInt(scanner.nextLine())));
        System.out.println("poder del personaje: ");
        vampiro.setPoder((Integer.parseInt(scanner.nextLine())));
        vampiro.setOro(500);
        vampiro.setSalud(5);
        System.out.println("edad del vampiro: ");
        vampiro.setEdad((Integer.parseInt(scanner.nextLine())));
        System.out.println("puntos de sangre del vampiro: ");


        vampiro.setArmadura(new ArrayList<Armadura>());
        vampiro.setArmas(new ArrayList<Arma>());
        vampiro.setArmaduraActiva(new Armadura());
        vampiro.setArmasActivas(new ArrayList<Arma>());
    return vampiro;
    }

}
