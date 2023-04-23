package Controladores;

import ORIGEN.Factory.CazadorFactory;
import ORIGEN.Factory.LicantropoFactory;
import ORIGEN.Factory.VampiroFactory;
import ORIGEN.*;

import java.util.List;
import java.util.Scanner;

public class PersonajeController {

    public void menu(){
        System.out.println("Seleccione una opción");
        System.out.println("1. Vampiro");
        System.out.println("2. Licántropo");
        System.out.println("3. Cazador");
        System.out.println("4. Cancelar");
    }
    public Usuario registrarPersonaje(Usuario user){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 1 && option != 2 && option != 3 && option != 4) {
            menu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                VampiroFactory vampiro = new VampiroFactory();
                user.setPersonaje(vampiro.crearPersonaje());
                break;
            case 2:
                LicantropoFactory licantropo = new LicantropoFactory();
                user.setPersonaje(licantropo.crearPersonaje());
                break;
            case 3:
                CazadorFactory cazador = new CazadorFactory();
                user.setPersonaje(cazador.crearPersonaje());
                break;
            case 4:
                break;
        }
       return user;
    }
    public void crearArma(){

    }
    public void crearArmadura(){

    }
    public Personaje editarArma( Personaje pj){
        List<Arma> lista = pj.getArmas();
        if (lista == null){
            Pantalla.imprimir("EL personaje no tiene Armas");
            return pj;
        }
        int t = lista.size();
        if (t<=0){
            Pantalla.imprimir("El personaje no tiene armas");
            Pantalla.imprimir("Volviendo...");
            return pj;
        }
        for (int i = 0; i < t; i++) {
            Arma actual = lista.get(i);
            Pantalla.imprimir(i+". "+actual.getNombre());
        }
        Pantalla.imprimir(t+". Cancelar operación.");
        int n = -1;
        while (n <0 || n > t){
            n = Pantalla.pedirenteros("Elije un arma");
        }
        if (n==t){
            return pj;
        }
        if (pj.getArmas().get(n)!=null)
            pj.getArmas().get(n).modificar();
        pj.setArmasActivas(null);
        return pj;
    }
    public Personaje editarArmadura(Personaje pj){
        List<Armadura> lista = pj.getArmadura();
        if (lista==null){
            Pantalla.imprimir("El personaje no tiene armaduras");
            Pantalla.imprimir("Volviendo...");
            return pj;
        }
        int t = lista.size();
        if (t<=0){
            Pantalla.imprimir("El personaje no tiene armaduras");
            Pantalla.imprimir("Volviendo...");
            return pj;
        }
        for (int i = 0; i < t; i++) {
            Armadura actual = lista.get(i);
            if (actual==null)
                continue;
            Pantalla.imprimir(i+". "+actual.getNombre());
        }
        Pantalla.imprimir(t+". Cancelar operación.");
        int n = -1;
        while (n <0 || n > t){
            n = Pantalla.pedirenteros("Elije una armadura");
        }
        if (n==t){
            return pj;
        }
        if (pj.getArmadura().get(n)!=null)
            pj.getArmadura().get(n).modificar();
        pj.setArmaduraActiva(null);
        return pj;
    }
    public Personaje cambiarArma(Personaje personaje){

        return personaje;
    }
    public Personaje cambiarArmadura(Personaje personaje){
        return personaje;

    }
    public void crearDebilidad(){

    }
    public void crearFortaleza(){

    }
    public Personaje modificarPersonaje(Personaje personaje) {

        Pantalla.imprimir("  1.Editar Arma o Armadura");
        Pantalla.imprimir("  2.Editar Fotalezas o Debilidades");
        Pantalla.imprimir("  3.Añadir Arma o Armadura");
        Pantalla.imprimir("  4.Añadir Fortaleza o Debilidad Arma");
        Pantalla.imprimir("  5.Añadir Esbirro");
        Pantalla.imprimir("  6.Modificar Estadisticas");
        Pantalla.imprimir("  7.Cancelar");

        int o = Pantalla.pedirenteros("Elige Opcion");
        switch (o){
            case 1:
                Pantalla.imprimir("  1.Editar Arma");
                Pantalla.imprimir("  2.Editar Armadura");
                Pantalla.imprimir("  Otro.Cancelar");
                o =  Pantalla.pedirenteros("Elige Opcion");
                if (o== 1){
                    return editarArma(personaje);
                } else if (0==2) {

                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;

        }
        return personaje;
    }
}

