package Controladores;

import ORIGEN.Factory.CazadorFactory;
import ORIGEN.Factory.LicantropoFactory;
import ORIGEN.Factory.VampiroFactory;
import ORIGEN.*;

import java.util.ArrayList;
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
    public Arma crearArma(){
        Arma arma = new Arma();
        arma.setNombre(Pantalla.pedircadena("Escribe el nombre del arma"));
        while (arma.getNombre().equals(""))
            arma.setNombre(Pantalla.pedircadena("No puede estar vacío: "));
        arma.setEmpuñadura(Pantalla.pedirenteros("Pulsa 1 para arma a 1 mano. Pulsa 2 para arma a 2 manos"));
        arma.setModificadorAtc(Pantalla.pedirenteros("valor Ataque"));
        arma.setModificadorDef(Pantalla.pedirenteros("valor Defensa"));
        return arma;
    }
    public Armadura crearArmadura(){
        Armadura armadura = new Armadura();
        armadura.setNombre(Pantalla.pedircadena("Escribe el nombre del arma"));
        while (armadura.getNombre().equals(""))
            armadura.setNombre(Pantalla.pedircadena("No puede estar vacío: "));
        armadura.setModificadorAtc(Pantalla.pedirenteros("valor Ataque"));
        armadura.setModificadorDef(Pantalla.pedirenteros("valor Defensa"));
        return armadura;

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
        boolean salir = true;
        while (!salir) {
            Pantalla.imprimir("  1.Editar Arma o Armadura");
            Pantalla.imprimir("  2.Editar Fotalezas o Debilidades");
            Pantalla.imprimir("  3.Añadir Arma o Armadura");
            Pantalla.imprimir("  4.Añadir Fortaleza o Debilidad Arma");
            Pantalla.imprimir("  5.Añadir Esbirro");
            Pantalla.imprimir("  6.Modificar Estadisticas");
            Pantalla.imprimir("  7.Cancelar");

            int o = Pantalla.pedirenteros("Elige Opcion");
            switch (o) {
                case 1://editar armas o armaduras
                    Pantalla.imprimir("  1.Editar Arma");
                    Pantalla.imprimir("  2.Editar Armadura");
                    Pantalla.imprimir("  Otro.Cancelar");
                    int b = Pantalla.pedirenteros("Elige Opcion");
                    if (b == 1) {
                        return editarArma(personaje);
                    } else if (b == 2) {
                        return editarArmadura(personaje);
                    }
                    break;
                case 2://editar fortalezas y debilidades
                    Pantalla.imprimir("  1.Editar Fortaleza");
                    Pantalla.imprimir("  2.Editar Debilidad");
                    Pantalla.imprimir("  Otro.Cancelar");
                    int c = Pantalla.pedirenteros("Elige Opcion");
                    if (c == 1) {
                        return editarFortaleza(personaje);
                    } else if (c == 2) {
                        return editarDebilidad(personaje);
                    }
                    break;
                case 3://crear armas y armaduras
                    Pantalla.imprimir("  1.Crear Arma");
                    Pantalla.imprimir("  2.Crear Armadura");
                    Pantalla.imprimir("  Otro.Cancelar");
                    int a = Pantalla.pedirenteros("Elige Opcion");
                    if (a == 1) {
                        Arma nueva = new Arma();
                        ArrayList<Arma> aux = personaje.getArmas();
                        if (aux == null)
                            aux = new ArrayList<>();
                        aux.add(nueva);
                        personaje.setArmas(aux);
                    } else if (a == 2) {
                        Armadura nueva = new Armadura();
                        ArrayList<Armadura> aux = personaje.getArmadura();
                        if (aux == null)
                            aux = new ArrayList<>();
                        aux.add(nueva);
                        personaje.setArmadura(aux);
                    }
                    break;
                case 4://crear debilidades y fortalezas
                    break;
                case 5://añadir esbirros
                    break;
                case 6://modifiar estadisticas
                    break;
                case 7://salir
                    salir = false;
                    break;

            }
        }
        return personaje;
    }


    private Personaje editarDebilidad(Personaje personaje) {
        List<Debilidad> lista = personaje.getDebilidades();
        if (lista==null){
            Pantalla.imprimir("El personaje no tiene debilidades");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        int t = lista.size();
        if (t<=0){
            Pantalla.imprimir("El personaje no tiene debilidades");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        for (int i = 0; i < t; i++) {
            Debilidad actual = lista.get(i);
            if (actual==null)
                continue;
            Pantalla.imprimir(i+". "+actual.getNombreDeb());
        }
        Pantalla.imprimir(t+". Cancelar operación.");
        int n = -1;
        while (n <0 || n > t){
            n = Pantalla.pedirenteros("Elije una debilidad");
        }
        if (n==t){
            return personaje;
        }
        if (personaje.getDebilidades().get(n)!=null)
            personaje.getDebilidades().get(n).modificar();
        return personaje;

    }

    private Personaje editarFortaleza(Personaje personaje) {
        List<Fortaleza> lista = personaje.getFortalezas();
        if (lista==null){
            Pantalla.imprimir("El personaje no tiene fortalezas");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        int t = lista.size();
        if (t<=0){
            Pantalla.imprimir("El personaje no tiene fortalezas");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        for (int i = 0; i < t; i++) {
            Fortaleza actual = lista.get(i);
            Pantalla.imprimir(i+". "+actual.getNombreFort());
        }
        Pantalla.imprimir(t+". Cancelar operación.");
        int n = -1;
        while (n <0 || n > t){
            n = Pantalla.pedirenteros("Elije una fortaleza");
        }
        if (n==t){
            return personaje;
        }
        if (personaje.getFortalezas().get(n)!=null)
            personaje.getFortalezas().get(n).modificar();
        return personaje;

    }
}

