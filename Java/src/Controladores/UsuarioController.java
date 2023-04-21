package Controladores;
import ORIGEN.Usuario;
import  ORIGEN.Personaje;

import java.util.List;
import java.util.Scanner;

public class UsuarioController {

    public Usuario menuUsuario(Usuario usuario){
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

            switch (option){//crear personaje
                case 1:
                    Personaje  personaje = usuario.getPersonaje();
                    if (personaje == null){
                        PersonajeController controller = new PersonajeController();
                        controller.registrarPersonaje(usuario);
                    }
                    else {
                        System.out.println("Ya tiene un personaje creado");
                        break;
                    }
                    break;

                case 2://dar de baja personaje
                    usuario.setPersonaje(null);
                    System.out.println("Personaje eliminado con exito");
                    break;
                case 3:// cambiar equipo activo
                    personaje = usuario.getPersonaje();
                    if (personaje == null){
                        System.out.println("NO tienes personaje creado");
                        break;
                    }
                    System.out.println("1.Cambiar arma activa");
                    System.out.println("1.Cambiar armadura activa");
                    System.out.println("3.Cancelar");
                    int option1 = sc.nextInt();
                    switch (option1){
                        case 1:
                            if (personaje.getArmasActivas() == null) {
                                System.out.println("NO tienes armas activas");
                            }
                            else {
                                PersonajeController contoller = new PersonajeController();
                                personaje = contoller.cambiarArma(personaje);
                                usuario.setPersonaje(personaje);
                            break;
                        }
                        case 2:
                            if (personaje.getArmaduraActiva() == null) {
                                System.out.println("NO tienes armadura activa");
                            }
                            else {
                                PersonajeController contoller = new PersonajeController();
                                personaje = contoller.cambiarArmadura(personaje);
                                usuario.setPersonaje(personaje);
                            }
                            break;
                        case 3:
                            break;
                    }

                case 4://lanzar desafio
                    desafiar(usuario);
                    break;
                case 5://ver combates anteriores
                    verCombate(usuario);
                    break;
                case 6://Ver ranking
                    verRanking();
                case 7://Dar de baja usuario


                case 8://cerrar sesion
                    salir= true;
                    break;
            }


        }
        return usuario;
    }




    public List<Usuario> menuOperador(List<Usuario> listaUsuarios, Usuario usu){



        return listaUsuarios;
    }
    public  Usuario buscarUsuario (String user){

        return null;
    }
    public void verCombate(Usuario user){

    }
    public void desafiar(Usuario user){

    }
    public void responderDesafio(){

    }
    private void verRanking() {
    }
}
