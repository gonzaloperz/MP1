package Controladores;
import ORIGEN.Usuario;
import  ORIGEN.Personaje;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;


public class UsuarioController {

    public Usuario menuUsuario(Usuario usuario) throws IOException, ClassNotFoundException {
        boolean salir = false;
        while (!salir){
            System.out.println(" ------MENU USUARIO------");
            System.out.println("  1.Crear personaje");
            System.out.println("  2.Eliminar personaje");
            System.out.println("  3.Cambiar equipo activo");
            System.out.println("  4.Lanzar desafio");
            System.out.println("  5.Resultados combates anteriores");
            System.out.println("  6.Ver Ranking global");
            System.out.println("  7.Darse de baja");
            System.out.println("  8.Cerrar sesion");

            int option = Pantalla.pedirenteros("Opcion");

            switch (option){
                case 1://crear personaje
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
                    int option1 = Pantalla.pedirenteros("opcion");
                    switch (option1){
                        case 1:
                                PersonajeController contoller = new PersonajeController();
                                personaje = contoller.cambiarArma(personaje);
                                usuario.setPersonaje(personaje);
                            break;

                        case 2:
                                PersonajeController controller = new PersonajeController();
                                personaje = controller.cambiarArmadura(personaje);
                                usuario.setPersonaje(personaje);
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
                    break;
                case 7://Dar de baja usuario
                    usuario = null;
                    Pantalla.imprimir("Se elimino el usuario");
                    salir = true;
                    break;
                case 8://cerrar sesion
                    salir= true;
                    break;
            }
        }
        return usuario;
    }




    public List<Usuario> menuOperador(List<Usuario> listaUsuarios, Usuario usu){
        boolean salir = false;
        while (!salir){
            System.out.println(" ------MENU OPERADOR------");
            System.out.println(" 1.Modificar personaje");
            System.out.println(" 2.Validar desafio");
            System.out.println(" 3.Banear Usuario");
            System.out.println(" 4.Desbanear Ususario");
            System.out.println(" 5.Resultados combate");
            System.out.println(" 6.Darse de baja");
            System.out.println(" 7.Cerrar sesion");

            int o = Pantalla.pedirenteros("Elegir opcion");

            switch (o){
                case 1:
                    for (Usuario a: listaUsuarios){
                        Pantalla.imprimir(a.getNombre());
                    }
                    String nombre = Pantalla.pedircadena("Usuario a buscar");
                    Usuario u = seleccionarUsuario(listaUsuarios,nombre);

                    if (u.getPersonaje() == null){
                        Pantalla.imprimir("El usuario no tiene personaje");
                        break;
                    }
                    PersonajeController pjController = new PersonajeController();
                    listaUsuarios.remove(u);
                    u.setPersonaje(pjController.modificarPersonaje(u.getPersonaje()));
                    listaUsuarios.add(u);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:break;
                case 7:
                    salir = true;
                    break;
            }
        }
        return listaUsuarios;
    }

    private Usuario seleccionarUsuario(List<Usuario> listaUsuarios, String nombre) {
        int size = listaUsuarios.size();
        if (size == 0){
            Pantalla.imprimir("No hay Usuarios registrados");
            return null;
        }
        for (Usuario u : listaUsuarios){
            if (u.getNombre().equals(nombre)){
                return u;
            }
        }
        Pantalla.imprimir("NO existe tal Usuario");
        return null;
    }
    public void verCombate(Usuario user){

    }
    public void desafiar(Usuario user){

    }
    public void responderDesafio(){

    }
    private void verRanking() throws IOException, ClassNotFoundException {
       Appcontroller aux = new Appcontroller();
       aux.Ranking();
    }
}
