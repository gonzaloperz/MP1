package Controladores;

import ORIGEN.Desafio;
import ORIGEN.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.time.LocalDate;

public class DesafiosController {
    private ArrayList<Desafio> listaDesafio;
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
    public void mostrarDesafios(){
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
    public void aceptarDesafio(){

    }
    public ArrayList<Desafio> historial(){
        return  null;
    }
    public void cargarDatos(){

    }
    public void validarDesafio(){

    }
    public void rechazarDesafio(){

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
