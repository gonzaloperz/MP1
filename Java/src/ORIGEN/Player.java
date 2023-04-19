/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import java.util.ArrayList;

/**
 *
 * @author paula
 */
public class Player extends Usuario{
    private String numeroReg;
    private ArrayList<Personajes> listaPersonajes ;

    //Constructor
    public Player (String nom, String nick, String password){
        super(nom, nick, password);
    }
}
