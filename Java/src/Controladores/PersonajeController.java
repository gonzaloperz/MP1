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
    public Usuario registrarPersonaje(Usuario user){//operación de los usuarios para poder crear su propio personaje
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 1 && option != 2 && option != 3 && option != 4) {//mientras que no se elija una opción de las dadas en el menú no avanza en el código
            menu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1://Crea un vampiro
                VampiroFactory vampiro = new VampiroFactory();
                user.setPersonaje(vampiro.crearPersonaje());
                user.getPersonaje().setOro(500);
                break;
            case 2://Crea un licántropo
                LicantropoFactory licantropo = new LicantropoFactory();
                user.setPersonaje(licantropo.crearPersonaje());
                break;
            case 3://Crea un cazador
                CazadorFactory cazador = new CazadorFactory();
                user.setPersonaje(cazador.crearPersonaje());
                break;
            case 4://Cancela la operación de crear personaje
                break;
        }
       return user;
    }
    public Arma crearArma(){//operacion exclusiva del operador que permite crear armas para los personajes de los jugadores
        Arma arma = new Arma();
        arma.setNombre(Pantalla.pedircadena("Escribe el nombre del arma"));
        while (arma.getNombre().equals("")){
            arma.setNombre(Pantalla.pedircadena("No puede estar vacío: "));
        }
        arma.setEmpuñadura(Pantalla.pedirenteros("Pulsa 1 para arma a 1 mano. Pulsa 2 para arma a 2 manos"));
        arma.setModificadorAtc(Pantalla.pedirenteros("valor Ataque"));
        arma.setModificadorDef(Pantalla.pedirenteros("valor Defensa"));
        return arma;
    }
    public Armadura crearArmadura(){//operacion exclusiva del operador que permite crear nuevas armaduras para los personajes de los jugadores
        Armadura armadura = new Armadura();
        armadura.setNombre(Pantalla.pedircadena("Escribe el nombre del arma"));
        while (armadura.getNombre().equals(""))
            armadura.setNombre(Pantalla.pedircadena("No puede estar vacío: "));
        armadura.setModificadorAtc(Pantalla.pedirenteros("valor Ataque"));
        armadura.setModificadorDef(Pantalla.pedirenteros("valor Defensa"));
        return armadura;

    }
    public Personaje editarArma( Personaje pj){//operación exclusiva del operador que permite modificar las armas que los usuarios pueden utilizar
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
        if (n == t){
            return pj;
        }
        if (pj.getArmas().get(n)!=null)
            pj.getArmas().get(n).modificar();//cuando selecciona un arma llama al método modificar de la clase arma que se ocupa de pedir los nuevos datos y asignarlos al arma
        pj.setArmasActivas(null);
        return pj;
    }
    public Personaje editarArmadura(Personaje pj){//operación exclusiva del operador que permite modificar una armadura.
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
            pj.getArmadura().get(n).modificar();// una vez seleccionada la armadura lla al metodo mof¡dificar de la clase armadura que actualiza la nueva informacion
        pj.setArmaduraActiva(null);
        return pj;
    }
    public Personaje cambiarArma(Personaje personaje){//permite a los usuarios cambiar el arma equipada.
        List<Arma> armasAc = personaje.getArmasActivas();
        Pantalla.imprimir("Arma equipada:  ");
        for(Arma a : armasAc){
            Pantalla.imprimir(a.getNombre());
        }

        Pantalla.imprimir(" ");
        Pantalla.imprimir("Armas dispopnibles");

        if (armasAc == null){//en caso de que no tenga ningún arma equipada
            armasAc = new ArrayList<>();
            List<Arma> disponibles = personaje.getArmas();
            for (Arma a: disponibles){
                Pantalla.imprimir(a.getNombre());// se muestra la lista de armas disponibles
            }
            String nueva = Pantalla.pedircadena("Seleciona el nuevo arma");
            for(Arma a : disponibles){
                if (a.getNombre().equals(nueva))
                    armasAc.add(a);
            }personaje.setArmasActivas((ArrayList<Arma>) armasAc);//se equipa el arma previamente seleccionada
        }else{//en caso de que tenga algún arma equipada
            List<Arma> disponibles = personaje.getArmas();
            for (Arma a : disponibles){
                Pantalla.imprimir(a.getNombre());}
            String nueva = Pantalla.pedircadena("Seleciona el nuevo arma");
            if (armasAc.size() == 1) {//comprueba el que el personaje solo tenga 1 arma equipada
                if (armasAc.get(0).getEmpuñadura() == 1) {//comprueba que el arma equipada sea de 1 mano para popder añadir otra arma
                    for (Arma b : disponibles) {
                        if (b.getNombre().equals(nueva) && b.getEmpuñadura() == 1)
                            armasAc.add(b);
                        else {//si el nuevo arma es de dos maos elimina la anterior y la reemplaza
                            Pantalla.imprimir("Se sustituira el arma vieja por la nueva");
                            armasAc.remove(0);
                            armasAc.add(b);
                        }
                    }
                }
            }
            else if (armasAc.size() == 2){//en caso de que tenga dos armas equipadas.
                Pantalla.imprimir("Se cambiara la primera arma equipada por la nueva si la opcion es válida");
                if (armasAc.get(0).getEmpuñadura() == 1) {
                    for (Arma b : disponibles) {
                        if (b.getNombre().equals(nueva) && b.getEmpuñadura() == 1) {// si tiene dos armas ya equipadas y elige equiparse una nueva de empuladura 1 mano, se sustituye el primer arma equipada al personaje
                            armasAc.remove(0);
                            armasAc.add(b);
                        }
                        else {
                            Pantalla.imprimir("Se sustituira el arma vieja por la nueva");//si el arma es de dos manos elimina las anteriores y las sustituye por la nueva
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
    public Personaje cambiarArmadura(Personaje personaje){ //permite a los usuarios cambiar la armadura equipada
         Armadura armaduraActiva = personaje.getArmaduraActiva();
         Pantalla.imprimir("Armadura activa Actual: " + personaje.getArmaduraActiva().getNombre());

         Pantalla.imprimir("Lista de armaduras disponibles");//se muestran las armaduras disponibles.
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
    public Debilidad crearDebilidad(){//Se crean, escogen valores y asignan las debilidades de los personajes
        Debilidad debilidad = new Debilidad();
        debilidad.setActivo(false);
        debilidad.setNombreFort(Pantalla.pedircadena("Nombre de la debilidad: "));
        while (debilidad.getNombreFort().equals(""))
            debilidad.setNombreFort(Pantalla.pedircadena("No puede estar vacío: "));
        debilidad.setSensibilidadFort(Pantalla.pedirenteros("Valor de la debilidad: "));
        return debilidad;
    }
    public Fortaleza crearFortaleza(){//Se crean, escogen valores y asignan las fortalezas de los personajes
        Fortaleza fortaleza = new Fortaleza();
        fortaleza.setActivo(false);
        fortaleza.setNombreFort(Pantalla.pedircadena("Nombre de la fortaleza: "));
        while (fortaleza.getNombreFort().equals(""))
            fortaleza.setNombreFort(Pantalla.pedircadena("No puede estar vacío: "));
        fortaleza.setSensibilidadFort(Pantalla.pedirenteros("Valor de la fortaleza: "));
        return fortaleza;
    }
    public Personaje modificarPersonaje(Personaje personaje) {//operación exclusiva de los operadores que permite cambiar datos de los personajes propios de cada usuario
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
                    if (b == 1) {//editar arma
                        return editarArma(personaje);
                    } else if (b == 2) {//editar armadura
                        return editarArmadura(personaje);
                    }
                    break;
                case 2://editar fortalezas y debilidades
                    Pantalla.imprimir("  1.Editar Fortaleza");
                    Pantalla.imprimir("  2.Editar Debilidad");
                    Pantalla.imprimir("  Otro.Salir");
                    int c = Pantalla.pedirenteros("Elige Opcion");
                    if (c == 1) {//editar fortaleza
                        return editarFortaleza(personaje);
                    } else if (c == 2) {//editar debilidad
                        return editarDebilidad(personaje);
                    }
                    break;
                case 3://crear armas y armaduras
                    Pantalla.imprimir("  1.Crear Arma");
                    Pantalla.imprimir("  2.Crear Armadura");
                    Pantalla.imprimir("  Otro.Cancelar");
                    int a = Pantalla.pedirenteros("Elige Opcion");
                    if (a == 1) {//crear arma
                        Arma nueva = crearArma();
                        ArrayList<Arma> aux = personaje.getArmas();
                        if (aux == null)//si un personaje no tiene lista de armas, se crea una.
                            aux = new ArrayList<>();
                        aux.add(nueva);//se añade a la lista de armas el arma creada.
                        personaje.setArmas(aux);
                        Pantalla.imprimir("Arma " + nueva.getNombre() + " creada");
                    } else if (a == 2) {//crear armadura
                        Armadura nueva = crearArmadura();
                        ArrayList<Armadura> aux = personaje.getArmadura();
                        if (aux == null)//si un personaje no tiene lista de armaduras, se crea una.
                            aux = new ArrayList<>();
                        aux.add(nueva);//se añade a la lista la nueva armadura
                        personaje.setArmadura(aux);
                        Pantalla.imprimir("Armadura  " + nueva.getNombre()  + "  creada");
                    }
                    break;
                case 4://crear debilidades y fortalezas
                    Pantalla.imprimir("1. Añadir Fortaleza");
                    Pantalla.imprimir("2. Añadir Debilidad");
                    Pantalla.imprimir("Otro. Cancelar");
                    o = Pantalla.pedirenteros("Elije una opción: ");
                    if (o == 1) {//añadir fortaleza
                        Fortaleza nueva = crearFortaleza();
                        ArrayList<Fortaleza> aux = personaje.getFortalezas();
                        if (aux == null)//si un personaje no tiene lista de fortalezas, se crea una.
                            aux = new ArrayList<>();
                        aux.add(nueva);//se añade a la lista la nueva fortaleza
                        personaje.setFortalezas(aux);
                    }
                    else if (o == 2) {
                        Debilidad nueva = crearDebilidad();
                        ArrayList<Debilidad> aux = personaje.getDebilidades();
                        if (aux == null)//si un personaje no tiene lista de debilidades, se crea una.
                            aux = new ArrayList<>();
                        aux.add(nueva);//se añade a la lista la nueva debilidad
                        personaje.setDebilidades(aux);
                    }
                    break;
                case 5://añadir esbirros
                    ArrayList<Esbirro> aux = personaje.getEsbirros();
                    if (aux == null)//si un personaje no tiene lista de esbirros, se crea una.
                        aux = new ArrayList<>();
                    Esbirro esbirro = personaje.crearEsbirros();
                    if (esbirro != null){
                        aux.add(esbirro);//se añade a la lista el nuevo  esbirro
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


    private Personaje editarDebilidad(Personaje personaje) { //permite editar cualquier debilidad que tenga el personaje
        List<Debilidad> lista = personaje.getDebilidades();
        if (lista == null){ //no existe la lista de debilidades
            Pantalla.imprimir("El personaje no tiene debilidades");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        int t = lista.size();
        if (t <= 0){ //el personaje no tiene ninguna debilidad creada ya que la lista de debilidades esta vacia
            Pantalla.imprimir("El personaje no tiene debilidades");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        //el personaje tiene una o mas debilidades creadas
        for (int i = 0; i < t; i++) {//se recorre la lista y se muestran por pantalla
            Debilidad actual = lista.get(i);
            if (actual == null)
                continue;
            Pantalla.imprimir(i + ". " + actual.getNombreDeb());
        }
        Pantalla.imprimir(t + ". Cancelar operación.");
        int n = -1;
        while (n < 0 || n > t){
            n = Pantalla.pedirenteros("Elije una debilidad");
        }
        if (n == t){//comprueba si en la lista solo hay una debilidad
            return personaje;
        }
        if (personaje.getDebilidades().get(n) != null)//se vuelve a comprobar que la debilidad escogida por el usuario exista y entonces se modifica
            personaje.getDebilidades().get(n).modificar();
        return personaje;

    }

    private Personaje editarFortaleza(Personaje personaje) { //permite editar cualquier fortaleza que tenga el personaje
        List<Fortaleza> lista = personaje.getFortalezas();
        if (lista == null){ //no existe la lista de fortalezas
            Pantalla.imprimir("El personaje no tiene fortalezas");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        int t = lista.size();
        if (t <= 0){ //el personaje no tiene ninguna fortaleza creada ya que la lista de fortalezas esta vacia
            Pantalla.imprimir("El personaje no tiene fortalezas");
            Pantalla.imprimir("Volviendo...");
            return personaje;
        }
        //el personaje tiene una o mas fortalezas creadas
        for (int i = 0; i < t; i++) {//se recorre la lista y se muestran por pantalla
            Fortaleza actual = lista.get(i);
            Pantalla.imprimir(i + ". "+actual.getNombreFort());
        }
        Pantalla.imprimir(t + ". Cancelar operación.");
        int n = -1;
        while (n < 0 || n > t){
            n = Pantalla.pedirenteros("Elije una fortaleza");
        }
        if (n == t){//comprueba si en la lista solo hay una fortaleza
            return personaje;
        }
        if (personaje.getFortalezas().get(n) != null)//se vuelve a comprobar que la fortaleza escogida por el usuario exista y entonces se modifica
            personaje.getFortalezas().get(n).modificar();
        return personaje;
    }
}

