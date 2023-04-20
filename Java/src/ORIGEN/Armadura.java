package ORIGEN;

import java.util.Scanner;

public class Armadura extends Equipo{

    Scanner scanner = new Scanner(System.in);
    @Override
    public Armadura modificar() {
        System.out.println(("vas a modificar esta armadura" + this.getNombre()));
        System.out.println(("cambiar nombre"));
        this.setNombre(scanner.nextLine());
        System.out.println(("cambiar ataque"));
        this.setModificadorAtc(scanner.nextInt());
        System.out.println(("cambiar defensa"));
        this.setModificadorDef(scanner.nextInt());
        return this;
    }
}
