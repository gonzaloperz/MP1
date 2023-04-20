package ORIGEN;
/**
 *
 * @author paula
 */


import java.io.Serializable;

public class Desafio implements Serializable {
    private final Usuario UserUno;
    private final Usuario UserDos;

    private Boolean validado;
    private Usuario ganador;

    //CONSTRUCTOR
    public Desafio(Usuario oponente1, Usuario oponente2){
        this.UserUno = oponente1;
        this.UserDos = oponente2;
    }
}