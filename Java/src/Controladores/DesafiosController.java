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
        Personaje jugador1 = desafio.getUserUno().getPersonaje();
        Personaje jugador2 = desafio.getUserDos().getPersonaje();
        int saludjugador1 = jugador1.getSalud();
        int saludjugador2 = jugador2.getSalud();
        int saludEsbirrosAtq = jugador1.saludEsbirros();
        int saludEsbirrosDef = jugador2.saludEsbirros();
        int rondas=0;
        Pantalla.imprimir("El combate va a empezar...");
        while (saludjugador1 > 0 && saludjugador2 > 0) {
            Pantalla.imprimir("Turno " + jugador1.getNombre());
            int ataqueJugador1 = jugador1.calcularAtaque();
            ataqueJugador1 = potencialAtaque(ataqueJugador1);
            int defensaJugador2 = jugador2.calcularDefensa();
            defensaJugador2 = potencialDefensa(defensaJugador2);
            if (ataqueJugador1 >= defensaJugador2) {
                if (jugador1.getClass() == Vampiro.class) {
                    ((Vampiro) jugador1).setPuntosSangre(((Vampiro) jugador1).getPuntosSangre() + 4);
                }
                if (saludEsbirrosDef > 0) {
                    saludEsbirrosDef--;
                } else {
                    if (jugador2.getClass() == Licantropo.class && ((Licantropo) jugador2).getRabia() < 3) {
                        ((Licantropo) jugador2).setRabia(((Licantropo) jugador2).getRabia() + 1);
                    }
                    if (jugador2.getClass() == Cazador.class && ((Cazador) jugador2).getVoluntad() > 0) {
                        ((Cazador) jugador2).setVoluntad(((Cazador) jugador2).getVoluntad() - 1);
                    }
                    saludjugador2--;
                }
            }
            Pantalla.imprimir("Turno " + jugador2.getNombre());
            int ataqueJugador2 = jugador2.calcularAtaque();
            ataqueJugador2 = potencialAtaque(ataqueJugador2);
            int defensaJugador1 = jugador2.calcularDefensa();
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
        if(saludjugador1 <= 0 && saludjugador2 <= 0){
            desafio.setGanador(0);
            Pantalla.imprimir("Empate");
        }
        else if (saludjugador1 <= 0){
            desafio.setGanador(1);
            Pantalla.imprimir("Jugador 2 ganador");
        }
        else if (saludjugador2 <= 0){
            desafio.setGanador(2);
            Pantalla.imprimir("Jugador 1 ganador");
            jugador1.setOro(jugador1.getOro() + desafio.getOroApostado());
            desafio.getUserUno().getPersonaje().setOro(desafio.getUserUno().getPersonaje().getOro() + desafio.getOroApostado());
            jugador2.setOro(jugador2.getOro() - desafio.getOroApostado());
            desafio.getUserDos().getPersonaje().setOro(desafio.getUserDos().getPersonaje().getOro() - desafio.getOroApostado());
        }
        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario1 = usuarioController.seleccionarUsuario(listausuarios, desafio.getUserUno().getNombre());
        Usuario usuario2 = usuarioController.seleccionarUsuario(listausuarios, desafio.getUserDos().getNombre());

        //esto es para devolver los personajes al estado original?
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
        desafio.getUserDos().setPersonaje(jugador2);
        desafio.getUserUno().setPersonaje(jugador1);
        desafio.setFecha(LocalDate.now());
        desafio.setRondas(rondas);
        desafio.setOroGanado(desafio.getOroApostado());
        guardardesafiocomp(listaDesafio, desafio);
        return desafio;
    }
    public void mostrarDesafios() throws IOException, ClassNotFoundException {
        cargarDatos();
        List<Desafio> aux = listaDesafio;
        for (int i = 0; i<aux.size() ; i++) {
            Desafio desafio = listaDesafio.get(i);
            Pantalla.imprimir("Jugador 1: " + desafio.getUserUno().getNickname());
            Pantalla.imprimir("Jugador 2: " + desafio.getUserDos().getNickname());
            Pantalla.imprimir("Rondas empleadas: " + desafio.getRondas());
            Pantalla.imprimir("Fecha: " + desafio.getFecha());
            if (desafio.getGanador() == 0){
                Pantalla.imprimir("Ganador: Empate");
            }
            else if (desafio.getGanador() == 1){
                Pantalla.imprimir("Ganador: " + desafio.getUserDos().getNickname());
            }
            else if (desafio.getGanador()==2) {
                Pantalla.imprimir("Ganador: " + desafio.getUserUno().getNickname());
            }
            Pantalla.imprimir("Contendientes con esbirros sin derrotar" );
            Pantalla.imprimir("Oro ganado:" + desafio.getOroGanado());
        }
    }
    public void guardardesafiocomp(List<Desafio>lista, Desafio desafio) throws IOException {
        File file = new File("listaDesafiosCompletados.dat");
        lista.add(desafio);
        if (file.exists()){
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
        if (u.getDesafio() != null){
            UsuarioController ucontroller = new UsuarioController();
            Usuario u1 = u.getDesafio().getUserUno();
            Usuario u2 = u.getDesafio().getUserDos();
            Pantalla.imprimir("Hay un nuevo desafio de " + u.getDesafio().getUserUno().getNickname() + " con una apuesta de " + u.getDesafio().getOroApostado() + " de oro.");
            int respuesta = Pantalla.pedirenteros("¿Desea aceptar el desafio? Si no lo acepta, deberá pagar el 10% de la apuesta. 0 = No ; 1 = Si");
            if (respuesta == 1) {
                Desafio d = this.iniciarDesafio(u.getDesafio(), listausuario);
                this.pagarGanador(d, listausuario);
            }
            else{
                Usuario usuario = ucontroller.seleccionarUsuario(listausuario, u2.getNombre());
                usuario.getPersonaje().setOro((int) Math.ceil((usuario.getPersonaje().getOro() - u.getDesafio().getOroApostado() * 0.10)));
                usuario = ucontroller.seleccionarUsuario(listausuario, u1.getNombre());
                usuario.getPersonaje().setOro((int) Math.ceil((usuario.getPersonaje().getOro() + u.getDesafio().getOroApostado() * 0.10)));
            }

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
    public void validarDesafio(List<Usuario> listausuario) throws IOException, ClassNotFoundException {
        List<Desafio> lista = cargarDesafios();
        if (lista.size() > 0) {
            int i = 0;
            for (Desafio d : lista) {
                Pantalla.imprimir(i + (". ") + d.getUserUno().getNombre() + (" vs ") + d.getUserDos().getNombre());
                i += 1;
            }
            int index = Pantalla.pedirenteros("Indique el desafio a validar");
            Desafio desafio = lista.get(index);
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
    public Desafio rechazarDesafio(Desafio desafio){

        return desafio;
    }
    public void ganador(){

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
        usu.getPersonaje().setOro(usu.getPersonaje().getOro() + d.getOroApostado());
        usu2.getPersonaje().setOro(usu2.getPersonaje().getOro() - d.getOroApostado());
    }
    public int potencialAtaque(int ataque) {
        int exito = 0;
        for (int i = 1; i <= ataque; i++) {
            Random random = new Random();
            int rango = random.nextInt(7);
            if (rango == 5 || rango == 6) {
                exito++;
            }
        }
        return exito;
    }

    public int potencialDefensa(int defensa) {
        int exito = 0;
        for (int i = 1; i <= defensa; i++) {
            Random random = new Random();
            int rango = random.nextInt(7);
            if (rango == 5 || rango == 6) {
                exito++;
            }
        }
        return exito;
    }

}
