package ORIGEN.Factory;

import java.util.ArrayList;
import java.util.List;

import Controladores.UsuarioController;
import Controladores.Pantalla;
import ORIGEN.Armadura;
import ORIGEN.Vampiro;
import ORIGEN.Arma;

public class VampiroFactory extends PersonajeFactory {
    ArrayList<Arma> armasac = new ArrayList<>();
    ArrayList<Arma> armas = new ArrayList<>();

    ArrayList<Armadura> armaduras=  new ArrayList<Armadura>();

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
        vampiro.setPuntosSangre(Pantalla.pedirenteros("Puntos de sangre"));
        Pantalla.imprimir("Personaje creado con éxito.");
        armas.add(armaDefault());//armas
        vampiro.setArmas(armas);
        armasac.add(armaDefault());//arma activa
        vampiro.setArmasActivas(armasac);
        armaduras.add(armaduraDefault());
        vampiro.setArmadura(armaduras);//armadura
        vampiro.setArmaduraActiva(armaduraDefault());//armadura activa
        return vampiro;
    }

    public Arma armaDefault(){
        Arma arma = new Arma();
        arma.setNombre("Palo");
        arma.setEmpuñadura(1);
        arma.setModificadorAtc(1);
        arma.setModificadorDef(0);
        return arma;
    }

    public Armadura armaduraDefault(){
        Armadura nueva = new Armadura();
        nueva.setNombre("Cota de malla");
        nueva.setModificadorAtc(1);
        nueva.setModificadorDef(1);
        return nueva;
    }
}
