package Controladores;
import ORIGEN.Usuario;
import  ORIGEN.Personaje;

import java.util.Scanner;

public class UsuarioController {

    public void menuUsuario(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir){
            System.out.println("  1.Crear personaje");
            System.out.println("  2.Eliminar personaje");
            System.out.println("  3.Cambiar equipo activo");
            System.out.println("  4.Lanzar desafio");
            System.out.println("  5.Resultados combates anteriores");
            System.out.println("  6.Ver Ranking global");
            System.out.println("  7.Darse de baja");
            System.out.println("  8.Cerrar sesion");

            int option = sc.nextInt();

            switch (option){
                case 1:
                    Personaje  personaje = usuario.getPersonaje();
                    if (personaje == null){
                        PersonajeController controller = new PersonajeController();
                        //usuario = controller.registrarPersonaje(usuario);
                    }
                    else {
                        System.out.println("Ya tiene un personaje creado");
                        break;
                    }
                    break;

                case 2:
                    personaje = usuario.getPersonaje();
                    usuario.setPersonaje(null);
                    break;
                case 8:
                    salir= true;
                    break;
            }


        }

    }
    public void menuOperador(){

    }
    public  Usuario buscarUsuario (String user){

        return null;
    }
    public void verCombate(){

    }
    public void desafiar(){

    }
    public void responderDesafio(){

    }
}
