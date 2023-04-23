package ORIGEN;

import Controladores.Pantalla;

import java.io.Serializable;
import java.util.Scanner;

public class Armadura extends Equipo implements Serializable {
    @Override
    public Armadura modificar() {
        System.out.println(("vas a modificar esta armadura" + this.getNombre()));
        this.setNombre(Pantalla.pedircadena("Establecer nombre"));
        this.setModificadorAtc(Pantalla.pedirenteros("cambiar ataque"));
        this.setModificadorDef(Pantalla.pedirenteros("cambiar defensa"));
        return this;
    }
}
