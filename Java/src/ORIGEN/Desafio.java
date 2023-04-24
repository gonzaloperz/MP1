package ORIGEN;
/**
 *
 * @author paula
 */


import java.io.Serializable;
import java.time.LocalDate;

public class Desafio implements Serializable {
    private final Usuario UserUno;
    private final Usuario UserDos;
    private int oroApostado;
    private int oroGanado;

    private Boolean validado;
    private int ganador;

    private String fecha;

    private int rondas;

    //CONSTRUCTOR
    public Desafio(Usuario oponente1, Usuario oponente2){
        this.UserUno = oponente1;
        this.UserDos = oponente2;
    }

    public Usuario getUserUno() {
        return UserUno;
    }

    public Usuario getUserDos() {
        return UserDos;
    }

    public int getOroApostado() {
        return oroApostado;
    }

    public void setOroApostado(int oroApostado) {
        this.oroApostado = oroApostado;
    }

    public int getOroGanado() {
        return oroGanado;
    }

    public void setOroGanado(int oroGanado) {
        this.oroGanado = oroGanado;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha.toString();
    }

}