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
        Pantalla.imprimir("Seleccione una opción");
        Pantalla.imprimir("1. Vampiro");
        Pantalla.imprimir("2. Licántropo");
        Pantalla.imprimir("3. Cazador");
        Pantalla.imprimir("4. Cancelar");
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
            Pantalla.imprimir(i+".   "+actual.getNombre());
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
        List<Arma> armasAc = personaje.getArmasActivas();
        Pantalla.imprimir("Arma equipada:  ");
        for(Arma a : armasAc){
            Pantalla.imprimir(a.getNombre());
        }

        Pantalla.imprimir(" ");
        Pantalla.imprimir("Armas dispopnibles");

        if (armasAc == null){
            armasAc = new ArrayList<>();
            List<Arma> disponibles = personaje.getArmas();
            for (Arma a: disponibles){
                Pantalla.imprimir(a.getNombre());
            }
            String nueva = Pantalla.pedircadena("Seleciona el nuevo arma");
            for(Arma a : disponibles){
                if (a.getNombre().equals(nueva))
                    armasAc.add(a);
            }personaje.setArmasActivas((ArrayList<Arma>) armasAc);
        }else{
            List<Arma> disponibles = personaje.getArmas();
            for (Arma a: disponibles){
                Pantalla.imprimir(a.getNombre());}
            String nueva = Pantalla.pedircadena("Seleciona el nuevo arma");
            if (armasAc.size()==1) {
                if (armasAc.get(0).getEmpuñadura() == 1) {
                    for (Arma b : disponibles) {
                        if (b.getNombre().equals(nueva) && b.getEmpuñadura() == 1)
                            armasAc.add(b);
                        else {
                            Pantalla.imprimir("Se sustituira el arma vieja por la nueva");
                            armasAc.remove(0);
                            armasAc.add(b);
                        }
                    }
                }
            }
            else if (armasAc.size()==2){
                Pantalla.imprimir("Se cambiara la primera arma equipada por la nueva si la opcion es válida");
                if (armasAc.get(0).getEmpuñadura() == 1) {
                    for (Arma b : disponibles) {
                        if (b.getNombre().equals(nueva) && b.getEmpuñadura() == 1) {
                            armasAc.remove(0);
                            armasAc.add(b);
                        }
                        else {
                            Pantalla.imprimir("Se sustituira el arma vieja por la nueva");
                            armasAc.remove(0);
                            armasAc.remove(1);
                            armasAc.add(b);
                        }
                    }
                }
            }
        }personaje.setArmasActivas((ArrayList<Arma>) armasAc);
        return personaje;
    }
    public Personaje cambiarArmadura(Personaje personaje){
         Armadura armaduraActiva = personaje.getArmaduraActiva();
         Pantalla.imprimir("Armadura activa Actual: " + personaje.getArmaduraActiva().getNombre());

         Pantalla.imprimir("Lista de armaduras disponibles");
         for ( Armadura a : personaje.getArmadura()){
             Pantalla.imprimir(a.getNombre());
         }
         String nueva = Pantalla.pedircadena("Selecciona la nueva armadura");
         for (Armadura a: personaje.getArmadura()){
             if (a.getNombre().equals(nueva))
                 personaje.setArmaduraActiva(a);
         }
        return personaje;

    }
    public Debilidad crearDebilidad(){
        Debilidad debilidad = new Debilidad();
        debilidad.setActivo(false);
        debilidad.setNombreFort(Pantalla.pedircadena("Nombre de la debilidad: "));
        while (debilidad.getNombreFort().equals(""))
            debilidad.setNombreFort(Pantalla.pedircadena("No puede estar vacío: "));
        debilidad.setSensibilidadFort(Pantalla.pedirenteros("Valor de la debilidad: "));
        return debilidad;
    }
    public Fortaleza crearFortaleza(){
        Fortaleza fortaleza = new Fortaleza();
        fortaleza.setActivo(false);
        fortaleza.setNombreFort(Pantalla.pedircadena("Nombre de la fortaleza: "));
        while (fortaleza.getNombreFort().equals(""))
            fortaleza.setNombreFort(Pantalla.pedircadena("No puede estar vacío: "));
        fortaleza.setSensibilidadFort(Pantalla.pedirenteros("Valor de la fortaleza: "));
        return fortaleza;
    }
    public Personaje modificarPersonaje(Personaje personaje) {
        boolean salir = false;
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
                    Pantalla.imprimir("  Otro.Salir");
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
                        Arma nueva = crearArma();
                        ArrayList<Arma> aux = personaje.getArmas();
                        if (aux == null)
                            aux = new ArrayList<>();
                        aux.add(nueva);
                        personaje.setArmas(aux);
                        Pantalla.imprimir("Arma  "+ nueva.getNombre()+"  creada");
                    } else if (a == 2) {
                        Armadura nueva = crearArmadura();
                        ArrayList<Armadura> aux = personaje.getArmadura();
                        if (aux == null)
                            aux = new ArrayList<>();
                        aux.add(nueva);
                        personaje.setArmadura(aux);
                        Pantalla.imprimir("Armadura  "+ nueva.getNombre()+"  creada");
                    }
                    break;
                case 4://crear debilidades y fortalezas
                    Pantalla.imprimir("1. Añadir Fortaleza");
                    Pantalla.imprimir("2. Añadir Debilidad");
                    Pantalla.imprimir("Otro. Cancelar");
                    o = Pantalla.pedirenteros("Elije una opción: ");
                    if (o==1) {
                        Fortaleza nueva = crearFortaleza();
                        ArrayList<Fortaleza> aux = personaje.getFortalezas();
                        if (aux==null)
                            aux= new ArrayList<>();
                        aux.add(nueva);
                        personaje.setFortalezas(aux);
                    }
                    else if (o==2) {
                        Debilidad nueva = crearDebilidad();
                        ArrayList<Debilidad> aux = personaje.getDebilidades();
                        if (aux==null)
                            aux= new ArrayList<>();
                        aux.add(nueva);
                        personaje.setDebilidades(aux);
                    }
                    break;
                case 5://añadir esbirros
                    ArrayList<Esbirro> aux = personaje.getEsbirros();
                    if (aux==null)
                        aux= new ArrayList<>();
                    Esbirro esbirro = personaje.crearEsbirros();
                    if (esbirro != null){
                        aux.add(esbirro);
                        personaje.setEsbirros(aux);
                    }
                    break;
                case 6://modifiar estadisticas
                    personaje.modificarDatos();
                    break;
                case 7://salir
                    salir = true;
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

