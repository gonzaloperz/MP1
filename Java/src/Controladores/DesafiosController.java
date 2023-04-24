package Controladores;

import ORIGEN.Desafio;
import ORIGEN.Personaje;

import java.util.ArrayList;
import java.util.Random;

public class DesafiosController {
    private ArrayList<Desafio> listaDesafio;
    public Desafio iniciarDesafio(Desafio desafio){
        Personaje jugador1 = desafio.getUserUno().getPersonaje();
        Personaje jugador2 = desafio.getUserDos().getPersonaje();
        int saludAtacante = jugador1.getSalud();
        int saludDesafiado = jugador2.getSalud();
        int saludEsbirrosAtq= jugador1.saludEsbirros();
        int saludEsbirrosDes = jugador2.saludEsbirros();
        saludAtacante+=saludEsbirrosAtq;
        saludDesafiado+=saludEsbirrosDes;
        int rondas=0;
        Pantalla.imprimir("El combate va a empezar...");
        while (saludAtacante>0 && saludDesafiado>0){
            Pantalla.imprimir("Turno jugador 1");
            int ataqueJugador1=jugador1.calcularAtaque();
            ataqueJugador1=potencialAtaque(ataqueJugador1);
            int defensaJugador2=jugador2.calcularDefensa();
            defensaJugador2=potencialDefensa(defensaJugador2);
            if (ataqueJugador1>=defensaJugador2){
                saludDesafiado--;
            }
            rondas++;
        }
        if(saludAtacante<=0 && saludDesafiado<=0desafio.setGanador(1);
            Pantalla.imprimir("Empate");
        }
        else if (saludAtacante<=0){
            desafio.setGanador(3);
            Pantalla.imprimir("Jugador 2 ganador");
        }
        else if (saludDesafiado<=0){
            desafio.setGanador(2);
            Pantalla.imprimir("Jugador 1 ganador");
        }
        return desafio;
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
