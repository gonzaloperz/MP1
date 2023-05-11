package Controladores;

import ORIGEN.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.time.LocalDate;

public class DesafiosController {
    private List<Desafio> listaDesafio = new ArrayList<Desafio>();
    public Desafio iniciarDesafio(Desafio desafio, List<Usuario> listausuarios) throws IOException {
        Personaje jugador1 = desafio.getUserUno().getPersonaje();//se establece como jugador 1 el personaje del usuario desafiante
        Personaje jugador2 = desafio.getUserDos().getPersonaje();//se establece como jugador 2 el personaje del usuario desafiado
        int saludjugador1 = jugador1.getSalud();
        int saludjugador2 = jugador2.getSalud();
        int saludEsbirrosAtq = jugador1.saludEsbirros();
        int saludEsbirrosDef = jugador2.saludEsbirros();
        int rondas=0;
        Pantalla.imprimir("El combate va a empezar...");
        while (saludjugador1 > 0 && saludjugador2 > 0) {//mientras los dos personajes tengan vida positiva se ejecutan turnos sin parar
            Pantalla.imprimir("Turno " + jugador1.getNombre());
            int ataqueJugador1 = jugador1.calcularAtaque();//ataque base del jugador 1
            ataqueJugador1 += modificadorataque(desafio, jugador1);// cantidad total de ataque del jugador 1
            ataqueJugador1 = potencialAtaque(ataqueJugador1);//Se calcula la cantidad de ataques que han tenido éxito del jugador 1
            int defensaJugador2 = jugador2.calcularDefensa();//defensa base del jugador 2
            defensaJugador2 += modificadordefensa(desafio, jugador2);//defensa total del jugador 2
            defensaJugador2 = potencialDefensa(defensaJugador2);//Se calcula la cantidad de defensas que han tenido éxito del jugador
            if (ataqueJugador1 >= defensaJugador2) {//si hay más ataques del jugador 1 que defensas del jugador 2 se lleva a cabo el ataque.
                if (jugador1.getClass() == Vampiro.class) {//si el atacante es un vampiro aumentan sus puntos de sangre
                    ((Vampiro) jugador1).setPuntosSangre(((Vampiro) jugador1).getPuntosSangre() + 4);
                }
                if (saludEsbirrosDef > 0) {//si los esbirros todavía tienen salud se les ataca a ellos
                    saludEsbirrosDef--;
                } else {//en caso de que no queden esbirros vivos se ataca al personaje
                    if (jugador2.getClass() == Licantropo.class && ((Licantropo) jugador2).getRabia() < 3) {//si el defensor es un licántropo con rabia menor que tres se le suma uno.
                        ((Licantropo) jugador2).setRabia(((Licantropo) jugador2).getRabia() + 1);
                    }
                    if (jugador2.getClass() == Cazador.class && ((Cazador) jugador2).getVoluntad() > 0) {//si el defensor es un cazador con voluntad mayor que cero, se le resta uno.
                        ((Cazador) jugador2).setVoluntad(((Cazador) jugador2).getVoluntad() - 1);
                    }
                    saludjugador2--;
                }
            }
            Pantalla.imprimir("Turno " + jugador2.getNombre());//se repite la misma mecánica invirtiendo los roles de atacante y defensor entre jugador 1 y jugador 2
            int ataqueJugador2 = jugador2.calcularAtaque();
            ataqueJugador2 += modificadorataque(desafio, jugador2);
            ataqueJugador2 = potencialAtaque(ataqueJugador2);
            int defensaJugador1 = jugador1.calcularDefensa();
            defensaJugador1 += modificadordefensa(desafio, jugador1);
            defensaJugador1 = potencialDefensa(defensaJugador1);
            if (ataqueJugador2 >= defensaJugador1) {
                if (jugador2.getClass() == Vampiro.class) {
                    ((Vampiro) jugador2).setPuntosSangre(((Vampiro) jugador2).getPuntosSangre() + 4);
                }
                if (saludEsbirrosAtq > 0) {
                    saludEsbirrosAtq--;
                }
            } else {
                if (jugador1.getClass() == Licantropo.class && ((Licantropo) jugador1).getRabia() < 3) {
                    ((Licantropo) jugador1).setRabia(((Licantropo) jugador1).getRabia() + 1);
                }
                if (jugador1.getClass() == Cazador.class && ((Cazador) jugador1).getVoluntad() > 0) {
                    ((Cazador) jugador1).setVoluntad(((Cazador) jugador1).getVoluntad() - 1);
                }
                saludjugador1--;
            }
            Pantalla.imprimir("Fin ronda " + rondas + ". Vida " + jugador1.getNombre() + ": " + saludjugador1 + ". Vida " + jugador2.getNombre() + ": " + saludjugador2 + ".");
            rondas++;
        }
        desafio.getUserUno().setPersonaje(jugador1);
        desafio.getUserDos().setPersonaje(jugador2);
        if(saludjugador1 <= 0 && saludjugador2 <= 0){//si los dos personajes se han quedado sin vida a la vez, es empate
            desafio.setGanador(0);
            Pantalla.imprimir("Empate");
        }
        else if (saludjugador1 <= 0){//pierde el jugador 1 y se paga al jugador 2
            desafio.setGanador(2);
            Pantalla.imprimir("Jugador 2 ganador");
        }
        else if (saludjugador2 <= 0){//pierde el jugador 2 y se paga al jugador 1
            desafio.setGanador(1);
            Pantalla.imprimir("Jugador 1 ganador");
        }
        this.pagarGanador(desafio,listausuarios);
        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario1 = usuarioController.seleccionarUsuario(listausuarios, desafio.getUserUno().getNombre());
        Usuario usuario2 = usuarioController.seleccionarUsuario(listausuarios, desafio.getUserDos().getNombre());

        //devuelve los personajes al estado original
        if (usuario1.getPersonaje().getClass() == Licantropo.class){
            ((Licantropo)usuario1.getPersonaje()).setRabia(0);
        }
        if (usuario1.getPersonaje().getClass() == Cazador.class){
            ((Cazador)usuario1.getPersonaje()).setVoluntad(3);
        }
        if (usuario2.getPersonaje().getClass() == Licantropo.class){
            ((Licantropo)usuario2.getPersonaje()).setRabia(0);
        }
        if (usuario2.getPersonaje().getClass() == Cazador.class){
            ((Cazador)usuario2.getPersonaje()).setVoluntad(3);
        }
        //se guarda el desafío en la lista de completados de ambos jugadores
        desafio.getUserDos().setPersonaje(jugador2);
        desafio.getUserUno().setPersonaje(jugador1);
        desafio.setFecha(LocalDate.now());
        desafio.setRondas(rondas);
        desafio.setOroGanado(desafio.getOroApostado());
        guardardesafiocomp(listaDesafio, desafio);
        return desafio;
    }

    public int modificadorataque(Desafio desafio, Personaje jugador){//se aplican las fortalezas del combate
        int modififcador = 0;
        switch (desafio.getModificador()) {
            case 1:
                if (jugador.getClass() == Cazador.class) {
                    modififcador = 1;
                }
                break;
            case 2:
                if (jugador.getClass() == Licantropo.class) {
                    modififcador = 1;
                }
                break;
            case 3:
                if (jugador.getClass() == Vampiro.class) {
                    modififcador = 1;
                    break;
                }
        }
        return modififcador;
    }
    public int modificadordefensa(Desafio desafio, Personaje jugador){//se aplican las debilidades del combate
        int modififcador = 0;
        switch (desafio.getModificador()) {
            case 1:
                if (jugador.getClass() == Vampiro.class) {
                    modififcador = 1;
                }
                break;
            case 2:
                if (jugador.getClass() == Cazador.class) {
                    modififcador = 1;
                }
                break;
            case 3:
                if (jugador.getClass() == Licantropo.class) {
                    modififcador = 1;
                    break;
                }
        }
        return modififcador;
    }
    public void guardardesafiocomp(List<Desafio>lista, Desafio desafio) throws IOException {//guarda en un archivo los desafíos completados
        File file = new File("listaDesafiosCompletados.dat");
        lista.add(desafio);
        if (file.exists()){//si el archivo no existe, se crea
            file.delete();
            file.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaDesafiosCompletados.dat"));
        for (int i = 0; i <lista.size(); i++) {
            if (lista.get(i) == null)
                continue;
            Desafio des = lista.get(i);
            oos.writeObject(des);
        }
        oos.close();
    }
    public List<Desafio> historial(){
        return  this.listaDesafio;
    }
    public void aceptarDesafio(List<Usuario> listausuario, Usuario u) throws IOException {
        if (u.getDesafio() != null){//si el usuario tiene algún desafío pendiente se le notifica
            UsuarioController ucontroller = new UsuarioController();
            Usuario u1 = u.getDesafio().getUserUno();
            Usuario u2 = u.getDesafio().getUserDos();
            Pantalla.imprimir("Hay un nuevo desafio de " + u.getDesafio().getUserUno().getNickname() + " con una apuesta de " + u.getDesafio().getOroApostado() + " de oro.");
            int respuesta = Pantalla.pedirenteros("¿Desea aceptar el desafio? Si no lo acepta, deberá pagar el 10% de la apuesta. 0 = No ; 1 = Si");
            if (respuesta == 1) {//si acepta el desafío, este da comienzo
                Desafio d = this.iniciarDesafio(u.getDesafio(), listausuario);
            }
            else{//si lo rechaza paga el 10% de la apuesta
                Usuario usuario = ucontroller.seleccionarUsuario(listausuario, u2.getNombre());
                usuario.getPersonaje().setOro((int) Math.ceil((usuario.getPersonaje().getOro() - u.getDesafio().getOroApostado() * 0.10)));
                usuario = ucontroller.seleccionarUsuario(listausuario, u1.getNombre());
                usuario.getPersonaje().setOro((int) Math.ceil((usuario.getPersonaje().getOro() + u.getDesafio().getOroApostado() * 0.10)));
            }
            //se borra el desafío como pendiente de acpetar
            Usuario usu1 = ucontroller.seleccionarUsuario(listausuario, u1.getNombre());
            Usuario usu2 = ucontroller.seleccionarUsuario(listausuario, u2.getNombre());
            usu1.setDesafio(null);
            usu2.setDesafio(null);
        }
    }
    //cargamos la lista con los desafios y la guardamos en el controlador
    public void cargarDatos() throws IOException, ClassNotFoundException {
        this.listaDesafio = cargarDesafios();
    }
    public void cargarDatos(List<Desafio> listaDesafios) throws IOException, ClassNotFoundException {
        guardarDesafios(listaDesafios);
        this.listaDesafio=listaDesafios;
    }
    //creamos los desafios
    private List<Desafio> cargarDesafios() throws IOException, ClassNotFoundException {
        List<Desafio> lista = new ArrayList<Desafio>();
        try {
            File file = new File("listaDesafios.dat");
            if (!file.exists()) {
                file.createNewFile();
                return lista;
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listaDesafios.dat"));
            Object aux = ois.readObject();
            while (aux != null) {
                if (aux instanceof Desafio)
                    lista.add((Desafio) aux);
                aux = ois.readObject();
            }
            ois.close();
        } catch (EOFException e1) {
            //Fin del fichero.
        }
        return lista;
    }
    //guardamos la lista de desafios en el fichero
    public List<Desafio> guardarDatos() throws  IOException{
        guardarDesafios(this.listaDesafio);
        return listaDesafio;
    }
    //guardamos los datos de los desafios creados
    public void guardarDesafios(List<Desafio>lista) throws IOException{
        File file = new File("listaDesafios.dat");
        if (file.exists()){
            file.delete();
            file.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listaDesafios.dat"));
        for (int i = 0; i <lista.size(); i++) {
            if (lista.get(i) == null)
                continue;
            Desafio desafio = lista.get(i);
            oos.writeObject(desafio);
        }
        oos.close();
    }
    public void agregarDesafio(Desafio desafio) throws IOException, ClassNotFoundException {
        cargarDatos(); //refresca cambios
        this.listaDesafio.add(desafio); //añade nuevo desafío al fichero
        guardarDatos();
    }
    public void validarDesafio(List<Usuario> listausuario) throws IOException, ClassNotFoundException {//operación exclusiva de operadores
        List<Desafio> lista = cargarDesafios();
        if (lista.size() > 0) {
            int i = 0;
            for (Desafio d : lista) {//se muestran por pantalla todos los desafíos pendientes
                Pantalla.imprimir(i + (". ") + d.getUserUno().getNombre() + (" vs ") + d.getUserDos().getNombre());
                i += 1;
            }
            int index = Pantalla.pedirenteros("Indique el desafio a validar");
            Desafio desafio = lista.get(index);//selecciona el desafío validado
            //selecciona la característica que implementa las fortalezas y debilidades en combate
            Pantalla.imprimir("1. Día Soleaddo.");
            Pantalla.imprimir("2. Luna llena.");
            Pantalla.imprimir("3. Eclipse lunar");
            int opcion = 0;
            while (opcion != 1 && opcion != 2 && opcion != 3){
                opcion = Pantalla.pedirenteros("Seleccione modificador");
                if (opcion != 1 && opcion != 2 && opcion != 3){
                    Pantalla.imprimir("No es una opción válida");
                }
            }
            //se valida todo el desafío y se envía la notificación al usuario desafiado.
            desafio.setModificador(opcion);
            lista.remove(index);
            this.listaDesafio = lista;
            guardarDatos();
            Usuario u2 = desafio.getUserDos();
            UsuarioController ucontroller = new UsuarioController();
            Usuario u = ucontroller.seleccionarUsuario(listausuario, u2.getNombre());
            u.setDesafio(desafio);
        }
        else{
            Pantalla.imprimir("No hay desafíos por validar.");
        }
    }
    public void pagarGanador(Desafio d, List<Usuario> listausuarios){
        String usuario = new String();
        String usuario2 = new String();
        if (d.getGanador() == 1){
            usuario = d.getUserUno().getNombre();
            usuario2 = d.getUserDos().getNombre();
        }
        if (d.getGanador() == 2) {
            usuario = d.getUserDos().getNombre();
            usuario2 = d.getUserUno().getNombre();
        }
        UsuarioController ucontroller = new UsuarioController();
        Usuario usu = ucontroller.seleccionarUsuario(listausuarios, usuario);
        Usuario usu2 = ucontroller.seleccionarUsuario(listausuarios, usuario2);
        if (usu != null){
            usu.getPersonaje().setOro(usu.getPersonaje().getOro() + d.getOroApostado());
        }
        if (usu2 != null) {
            usu2.getPersonaje().setOro(usu2.getPersonaje().getOro() - d.getOroApostado());
        }
    }
    public int potencialAtaque(int ataque) {//se ingresa el valor de ataque ya calculado
        int exito = 0;
        for (int i = 1; i <= ataque; i++) {//se generan tantos números entre 1 y 6 como ataque se pase por parámetro
            Random random = new Random();
            int rango = random.nextInt(7);
            if (rango == 5 || rango == 6) {//se seleccionan los 5 y 6
                exito++;
            }
        }
        return exito;//devuelve el número de ataques que realiza
    }

    public int potencialDefensa(int defensa) { //se ingresa el valor de ataque ya calculado
        int exito = 0;
        for (int i = 1; i <= defensa; i++) {//se generan tantos números entre 1 y 6 como defensa se pase por parámetro
            Random random = new Random();
            int rango = random.nextInt(7);
            if (rango == 5 || rango == 6) {//se seleccionan los 5 y 6
                exito++;
            }
        }
        return exito;//devuelve el número de defensas que realiza
    }

}
