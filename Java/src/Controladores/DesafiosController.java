package Controladores;

import ORIGEN.Desafio;
import ORIGEN.Operador;
import ORIGEN.Personaje;
import ORIGEN.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.time.LocalDate;

public class DesafiosController {
    private List<Desafio> listaDesafio = new ArrayList<Desafio>();
    public Desafio iniciarDesafio(Desafio desafio){
        Personaje jugador1 = desafio.getUserUno().getPersonaje();
        Personaje jugador2 = desafio.getUserDos().getPersonaje();
        int saludjugador1 = jugador1.getSalud();
        int saludjugador2 = jugador2.getSalud();
        int saludEsbirrosAtq= jugador1.saludEsbirros();
        int saludEsbirrosDes = jugador2.saludEsbirros();
        saludjugador1+=saludEsbirrosAtq;
        saludjugador2+=saludEsbirrosDes;
        int rondas=0;
        Pantalla.imprimir("El combate va a empezar...");
        while (saludjugador1>0 && saludjugador2>0){
            Pantalla.imprimir("Turno jugador 1");
            int ataqueJugador1=jugador1.calcularAtaque();
            ataqueJugador1=potencialAtaque(ataqueJugador1);
            int defensaJugador2=jugador2.calcularDefensa();
            defensaJugador2=potencialDefensa(defensaJugador2);
            if (ataqueJugador1>=defensaJugador2){
                saludjugador2--;
            }
            Pantalla.imprimir("Turno jugador 2");
            int ataqueJugador2=jugador2.calcularAtaque();
            ataqueJugador2=potencialAtaque(ataqueJugador1);
            int defensaJugador1=jugador2.calcularDefensa();
            defensaJugador1=potencialDefensa(defensaJugador1);
            if (ataqueJugador2>=defensaJugador1){
                saludjugador1--;
            }
            Pantalla.imprimir("Fin ronda "+rondas);
            rondas++;
        }
        desafio.getUserUno().setPersonaje(jugador1);
        desafio.getUserDos().setPersonaje(jugador2);
        if(saludjugador1<=0 && saludjugador2<=0){
            desafio.setGanador(0);
            Pantalla.imprimir("Empate");
        }
        else if (saludjugador1<=0){
            desafio.setGanador(1);
            Pantalla.imprimir("Jugador 2 ganador");
        }
        else if (saludjugador2<=0){
            desafio.setGanador(2);
            Pantalla.imprimir("Jugador 1 ganador");
            jugador1.setOro(jugador1.getOro()+desafio.getOroApostado());
            desafio.getUserUno().setOro(desafio.getUserUno().getOro()+desafio.getOroApostado());

            jugador2.setOro(jugador2.getOro()-desafio.getOroApostado());
            desafio.getUserDos().setOro(desafio.getUserDos().getOro()-desafio.getOroApostado());
        }
        desafio.getUserDos().setPersonaje(jugador2);
        desafio.getUserUno().setPersonaje(jugador1);
        desafio.setFecha(LocalDate.now());
        desafio.setRondas(rondas);
        desafio.setOroGanado(desafio.getOroApostado());

        return desafio;
    }
    public void mostrarDesafios() throws IOException, ClassNotFoundException {
        cargarDatos();
        List<Desafio> aux = listaDesafio;
        for (int i = 0; i<aux.size() ;i++) {
            Desafio desafio = listaDesafio.get(i);
            Pantalla.imprimir("Jugador 1: " + desafio.getUserUno().getNickname());
            Pantalla.imprimir("Jugador 2: " + desafio.getUserDos().getNickname());
            Pantalla.imprimir("Rondas empleadas: " + desafio.getRondas());
            Pantalla.imprimir("Fecha: " + desafio.getFecha());
            if (desafio.getGanador()==0){
                Pantalla.imprimir("Ganador: Empate");
            }
            else if (desafio.getGanador()==1){
                Pantalla.imprimir("Ganador: "+desafio.getUserDos().getNickname());
            }
            else if (desafio.getGanador()==2) {
                Pantalla.imprimir("Ganador: "+desafio.getUserUno().getNickname());
            }
            Pantalla.imprimir("Contendientes con esbirros sin derrotar" );
            Pantalla.imprimir("Oro ganado:" + desafio.getOroGanado());
        }
    }

    public List<Desafio> historial(){
        return  this.listaDesafio;
    }
    public void aceptarDesafio(Usuario u){
        /*for (Desafio desafio: listaDesafio) {
            if (desafio.getUserUno().getDesafio() != null) {
                int respuesta;
                Pantalla.imprimir("Hay un nuevo desafio de " + desafio.getUserDos().getNickname());
                respuesta = Pantalla.pedirenteros("¿Desea aceptar el desafio? 0 = No ; 1 = Si");
                if (respuesta == 0) {
                    Usuario u1 = desafio.getUserUno();
                    Usuario u2 = desafio.getUserDos();
                    u1.setDesafio(null);
                    u2.setDesafio(null);
                    return;
                } else if (respuesta == 1) {
                    Desafio d = this.iniciarDesafio(desafio);
                }
            }
        }*/
        if (u.getDesafio() != null){
            Pantalla.imprimir("Hay un nuevo desafio de " + u.getDesafio().getUserDos().getNickname());
            int respuesta = Pantalla.pedirenteros("¿Desea aceptar el desafio? 0 = No ; 1 = Si");
            if (respuesta == 0) {
                Usuario u1 = u.getDesafio().getUserUno();
                Usuario u2 = u.getDesafio().getUserDos();
                u1.setDesafio(null);
                u2.setDesafio(null);
                return;
            } else if (respuesta == 1) {
                Desafio d = this.iniciarDesafio(u.getDesafio());
            }
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
            if (lista.get(i)==null)
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
        int i = 0;
        for (Desafio d : lista){
            Pantalla.imprimir(i + (". ") + d.getUserUno().getNombre() + (" vs ") + d.getUserDos().getNombre());
            i += 1;
        }
        int index = Pantalla.pedirenteros("Indique el desafio a validar");
        Desafio desafio = lista.get(index);
        Usuario u2 = desafio.getUserDos();
        u2.setDesafio(desafio);
        Appcontroller appc = new Appcontroller();
        appc.guardarUsuarios(listausuario);
    }
    public Desafio rechazarDesafio(Desafio desafio){

        return desafio;
    }
    public void ganador(){

    }
    public void pagarGanador(){

    }
    public int potencialAtaque(int ataque) {
        int exito=0;
        Random random= new Random();
        int rango = random.nextInt(7);
        if (rango==5||rango==6){
            exito++;
        }
        return exito;
    }

    public int potencialDefensa(int defensa) {
        int exito=0;
        Random random= new Random();
        int rango = random.nextInt(7);
        if (rango==5||rango==6){
            exito++;
        }
        return exito;
    }

}
