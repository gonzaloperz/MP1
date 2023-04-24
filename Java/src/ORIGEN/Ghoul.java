package ORIGEN;

import java.io.Serializable;

public class Ghoul extends Esbirro implements Serializable {
    private Integer dependencia;

    public Ghoul(String nombre, int salud, int valorDependencia, String esbirroDependencia) {
        super(nombre, salud);
    }
}
