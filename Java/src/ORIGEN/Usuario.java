package ORIGEN;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author paula
 */
public class Usuario {

    private String nombre;
    private String nickname;
    private String contrasena;

    //Constructor
    public Usuario (String nom, String nick, String password){
        this.nombre = nom;
        this.nickname = nick;
        this.contrasena = password;
    }
}