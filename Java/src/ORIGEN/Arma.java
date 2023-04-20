package ORIGEN;

import java.io.Serializable;
import java.util.Scanner;

public class Arma extends Equipo implements Serializable {

    Scanner scanner = new Scanner(System.in);
    private int empuñadura; //1 una mano 2 dos manos
    //@override modificar(){}

    public void setEmpuñadura(int manos){
        this.empuñadura = manos;
    }

    public int getEmpuñadura(){
        return this.empuñadura;
    }

    @Override
    public Arma modificar(){
        System.out.println(("Vas a modificar esta arma" + this.getNombre()));
        System.out.println(("cambiar nombre"));
        this.setNombre(scanner.nextLine());
        System.out.println(("establece ataque"));
        this.setModificadorAtc(scanner.nextInt());
        System.out.println(("establece defensa"));
        this.setModificadorDef(scanner.nextInt());
        System.out.println(("establece empuñadura"));
        this.setEmpuñadura(scanner.nextInt());
    return this;
    }
}
